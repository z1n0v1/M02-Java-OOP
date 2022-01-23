package logger;

import logger.interfaces.File;

public class LogFile implements File {
    private final StringBuilder builder;
    private int sum;

    public LogFile() {
        builder = new StringBuilder();
        sum = 0;
    }

    public void write(String s) {
        for (char c : s.toCharArray())
            if(Character.isAlphabetic(c))
                sum += c;
        builder.append(s);
    }

    public int getSize() {
        return sum;
    }
}
