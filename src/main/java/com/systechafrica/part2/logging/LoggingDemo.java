package com.systechafrica.part2.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LoggingDemo {
    private static final Logger LOGGER = Logger.getLogger(LoggingDemo.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        FileHandler fileHandler = new FileHandler("log.txt");
        CustomLogFormatter formatter = new CustomLogFormatter();
        LOGGER.addHandler(fileHandler);
        fileHandler.setFormatter(formatter);

        LOGGER.info("Info message logging\n");
        LOGGER.severe("Error message logging\n");
        LOGGER.warning("Warning message logging\n");
        test();

    }

    public static void test() {
        LOGGER.info("Info message logging test\n");
        LOGGER.severe("Error message logging test\n");
        LOGGER.warning("Warning message logging test\n");
    }
}
