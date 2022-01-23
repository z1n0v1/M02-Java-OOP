import logger.*;
import logger.appenders.ConsoleAppender;
import logger.appenders.FileAppender;
import logger.factories.LoggerFactory;
import logger.interfaces.Appender;
import logger.interfaces.File;
import logger.interfaces.Layout;
import logger.interfaces.Logger;
import logger.layouts.SimpleLayout;
import logger.layouts.XmlLayout;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LoggerFactory loggerFactory = new LoggerFactory();
        LoggerInfoParser loggerInfoParser = new LoggerInfoParser();
        Logger logger = loggerFactory.produce(loggerInfoParser.readLoggerInfo(scanner));

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\|");
            switch (ReportLevel.valueOf(tokens[0])) {
                case INFO: logger.logInfo(tokens[1], tokens[2]); break;
                case WARNING: logger.logWarning(tokens[1], tokens[2]); break;
                case ERROR: logger.logError(tokens[1], tokens[2]); break;
                case CRITICAL: logger.logCritical(tokens[1], tokens[2]); break;
                case FATAL: logger.logFatal(tokens[1], tokens[2]); break;
            }
        }
        System.out.println(logger);

    }
}

