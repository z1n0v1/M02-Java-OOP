package logger.factories;

import logger.ReportLevel;
import logger.appenders.ConsoleAppender;
import logger.appenders.FileAppender;
import logger.interfaces.Appender;
import logger.interfaces.Factory;
import logger.interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {
    public AppenderFactory() {
    }

    @Override
    public Appender produce(String input) {
        LayoutFactory layoutFactory = new LayoutFactory();
        String[] tokens = input.split("\\s+");
        Layout layout = layoutFactory.produce(tokens[1]);
        Appender appender = null;
        if(tokens[0].equals("ConsoleAppender")) {
            appender = new ConsoleAppender(layout);
        } else if (tokens[0].equals("FileAppender")) {
            appender = new FileAppender(layout);
        }
        if(tokens.length > 2)
            appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        return appender;
    }

}
