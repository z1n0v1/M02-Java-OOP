package logger.appenders;

import logger.interfaces.Appender;
import logger.interfaces.Layout;
import logger.ReportLevel;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public ConsoleAppender(Layout layout) {
        this(layout, ReportLevel.INFO);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        String logMessage = getLayout().format(date, reportLevel, message);
        if (reportLevel.compareTo(getReportLevel()) >= 0) {
            System.out.println(logMessage);
            countMessage();
        }
    }
}
