package com.systechafrica.part3.jdbc;

import com.systechafrica.part3.logging.CustomLogFormatter;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import static com.systechafrica.part3.jdbc.JDBCUtils.findCustomerByEmail;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            CustomLogFormatter formatter = new CustomLogFormatter();
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);
            findCustomerByEmail("alice@example.com");
            //findAllCustomers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
