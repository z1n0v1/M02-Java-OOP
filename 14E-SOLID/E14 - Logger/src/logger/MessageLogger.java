package logger;

import logger.interfaces.Appender;
import logger.interfaces.Logger;

import java.util.Arrays;

public class MessageLogger implements Logger {
    Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String date, String message) {
        log(date, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String date, String message) {
        log(date, message, ReportLevel.WARNING);
    }

    @Override
    public void logError(String date, String message) {
        log(date, message, ReportLevel.ERROR);
    }

    @Override
    public void logCritical(String date, String message) {
        log(date, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String date, String message) {
        log(date, message, ReportLevel.FATAL);
    }

    private void log(String date, String message, ReportLevel reportLevel) {
        Arrays.stream(appenders).forEach(appender -> appender.append(date, reportLevel, message));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Logger info").append(System.lineSeparator());
        for (Appender appender : appenders) {
            stringBuilder.append(appender);
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
