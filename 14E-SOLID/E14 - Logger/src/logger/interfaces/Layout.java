package logger.interfaces;

import logger.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
}
