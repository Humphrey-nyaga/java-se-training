package com.systechafrica.part3.inputoutput;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class WorkingWithFiles {
    public static void workWithFiles() throws IOException {
        String absolutePath = "/home/hum/PROJECTS/java-se-training/src/main/java/com/systechafrica/part3/inputoutput/WorkingWithFiles.java";
        String relativePath = "java-se-training/src/main/java/com/systechafrica/part3/inputoutput";
        System.out.println(System.getProperty("file.separator"));
        String fileSeparator = System.getProperty("file.separator");
        File logFile = new File("/home/hum/PROJECTS/java-se-training/log.txt");
        System.out.println(logFile.exists()); //check if file exists
        System.out.println(logFile.isFile()); //check if is a file
        System.out.println(logFile.isDirectory()); // is directory?
        System.out.println(Instant.ofEpochMilli(logFile.lastModified())); // last modified date
        System.out.println(logFile.getFreeSpace());

        File baseDirectory  = new File("/home/hum/PROJECTS/java-se-training");
        if(baseDirectory.exists() && baseDirectory.isDirectory()){
            File[] listFiles = baseDirectory.listFiles();

            File tmpFile  = new File(baseDirectory,"tmp"); // create a new directory
            tmpFile.mkdir();

            // create file
            File log = new File("tmp","log2.txt");
            log.createNewFile();
            for (File file: listFiles) {
                System.out.println(file.getName());
            }

            // delete file
            log.delete();
        }
    }
    public static void main(String[] args) throws IOException {
     workWithFiles();
    }
}
