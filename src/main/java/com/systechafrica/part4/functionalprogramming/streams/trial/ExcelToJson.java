package com.systechafrica.part4.functionalprogramming.streams.trial;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public class ExcelToJson {
    private static final  Logger LOGGER = Logger.getLogger(ExcelToJson.class.getName());

    public static void main(String[] args) {
        File file = new File("src/main/java/com/systechafrica/part4/functionalprogramming/streams/trial/FacilityExportMaterialList.xlsx");


        /* Check file extension is an excel sheet
         *FileNameUtils.getExtension(file.getName()).equals("xlsx");
         * FileNameUtils.getExtension(file.getName()).equals("xls");
         * We'll not need this one here since the WorkbookFactory.create() method automatically checks
         * to ensure file is excel.
         * */
        if (file.exists()) {
            excelToJsonConverter(file);
        } else {
            LOGGER.info("Please provide an existing file");
        }
    }

    private static void excelToJsonConverter(File file) {
        Map<String, Object> properties = new HashMap<>(1);
        properties.put(JsonGenerator.PRETTY_PRINTING, false);
        /*
        * Get the file name and extract it and use the extracted name as the name
        * of the json file*/
        String newJsonFileName = FilenameUtils.removeExtension(file.getName());
        String newJsonFileAndPath = file.getParent() + File.separator + newJsonFileName;


        try {
            Sheet sheet;
            try (Workbook workbook = WorkbookFactory.create(file)) {
                LOGGER.info("File exists conversion to JSON will begin shortly...");
                sheet = workbook.getSheetAt(0);
                LOGGER.info("Processing sheet: " + sheet);
            }

            try (JsonGenerator jsonGenerator = Json.createGeneratorFactory(properties).createGenerator(new FileWriter( newJsonFileAndPath + ".json"))) {
                jsonGenerator.writeStartArray();

                /*Assumption is that every excel sheet will have the first row as the headers of the data
                * The extracted values from row one will be used as key values in the generated JSON
                * E.g
                * firstName| lastName | address |
                * John       Doe       12th Ave.
                *
                * becomes
                * [{
                * "firstName":"John",
                * "lastName":"Doe",
                * "address" :"address"
                * }]
                * */
                Row headerRow = sheet.getRow(0);

                for (Iterator<Row> rowsIterator = sheet.rowIterator(); rowsIterator.hasNext(); ) {
                    Row row = rowsIterator.next();
                    if (row.getRowNum() != 0) {
                        jsonGenerator.writeStartObject();

                        // read cell values and their headers and write as json
                        for (Iterator<Cell> cellsIterator = row.cellIterator(); cellsIterator.hasNext(); ) {
                            Cell cell = cellsIterator.next();
                            String header = headerRow.getCell(cell.getColumnIndex()).getStringCellValue();
                            CellType cellType = cell.getCellType();

                            if (cellType == CellType.NUMERIC) {
                                int value = (int) cell.getNumericCellValue();
                                jsonGenerator.write(header, value);
                            } else {
                                String value = cell.getStringCellValue();
                                jsonGenerator.write(header, value);
                            }
                        }
                        LOGGER.info("Row " + row.getRowNum() + " written as JSON!!");
                        jsonGenerator.writeEnd();
                    }
                }

                jsonGenerator.writeEnd();
                LOGGER.info("Success!!.Writing JSON file completed...");
            }
        } catch (FileNotFoundException e) {
            LOGGER.severe("File Not Found: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }catch ( EncryptedDocumentException e ){
            LOGGER.severe("Encrypted File :" + e.getMessage());
        }
    }
}
