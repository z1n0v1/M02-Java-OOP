package logger.factories;

import logger.MessageLogger;
import logger.interfaces.Appender;
import logger.interfaces.Factory;
import logger.interfaces.Logger;

public class LoggerFactory implements Factory<Logger> {
    public LoggerFactory() {
    }

    @Override
    public Logger produce(String input) {
        Logger logger = null;
        String[] tokens = input.split(System.lineSeparator());
        Appender[] appenders = new Appender[tokens.length];
        AppenderFactory appenderFactory = new AppenderFactory();
        for (int i = 0; i < tokens.length; i++) {
            appenders[i] = appenderFactory.produce(tokens[i]);
        }

        return new MessageLogger(appenders);
    }
}
