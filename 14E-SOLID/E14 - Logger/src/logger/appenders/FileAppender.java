package logger.appenders;

import logger.LogFile;
import logger.interfaces.File;
import logger.interfaces.Layout;
import logger.ReportLevel;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public FileAppender(Layout layout) {
        super(layout, ReportLevel.INFO);
        this.file = new LogFile();
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        String logMessage = getLayout().format(date, reportLevel, message);
        if (reportLevel.compareTo(getReportLevel()) >= 0) {
            file.write(logMessage);
            countMessage();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + file.getSize();
    }
}
