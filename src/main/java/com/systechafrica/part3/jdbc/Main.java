package com.systechafrica.part3.jdbc;

import com.systechafrica.part3.logging.CustomLogFormatter;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            CustomLogFormatter formatter = new CustomLogFormatter();
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
