package logger.interfaces;

import logger.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel error);
}
