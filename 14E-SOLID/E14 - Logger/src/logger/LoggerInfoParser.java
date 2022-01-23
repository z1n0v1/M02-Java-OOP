package logger;

import java.util.Scanner;

public class LoggerInfoParser {
    public String readLoggerInfo(Scanner scanner) {
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
