package com.systechafrica.pos.posreviewed.logger;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class FileLogger extends Formatter {
    public static Logger LOGGER;

    public static Logger getLogger() {
        if (LOGGER == null) {
            LOGGER = Logger.getLogger(FileLogger.class.getName());
        }
        return LOGGER;
    }

    @Override
    public String format(LogRecord record) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String method = record.getSourceMethodName();
        String level = record.getLevel().getName();
        String message = record.getMessage();
        Instant instant = record.getInstant();
        LocalDateTime now = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return pattern.format(now) + " | " + method + " | " + level + " | " + message + "\n";
    }
}
