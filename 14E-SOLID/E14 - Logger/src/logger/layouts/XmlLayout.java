package logger.layouts;

import logger.interfaces.Layout;
import logger.ReportLevel;

public class XmlLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format(
                "<log>%n" +
                        "\t<date>%s</date>%n" +
                        "\t<level>%s</level>%n" +
                        "\t<message>%s</message>%n" +
                        "</log>%n", date, reportLevel, message);
    }
}
