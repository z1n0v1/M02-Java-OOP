package logger.appenders;

import logger.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.Layout;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int messageCount;

    public BaseAppender(Layout layout, ReportLevel reportLevel) {
        setLayout(layout);
        setReportLevel(reportLevel);
        messageCount = 0;
    }

    protected Layout getLayout() {
        return layout;
    }

    private void setLayout(Layout layout) {
        this.layout = layout;
    }

    protected ReportLevel getReportLevel() {
        return reportLevel;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected void countMessage() {
        messageCount++;
    }

    public int getMessageCount() {
        return messageCount;
    }

    @Override
    public String toString() {
        return String.format(
                "Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                getClass().getSimpleName(), layout.getClass().getSimpleName(), reportLevel, getMessageCount());
    }
}
