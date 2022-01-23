package logger.factories;

import logger.interfaces.Factory;
import logger.interfaces.Layout;
import logger.layouts.SimpleLayout;
import logger.layouts.XmlLayout;

public class LayoutFactory implements Factory<Layout> {
    public LayoutFactory() {
    }

    @Override
    public Layout produce(String input) {
        if(input.equals("SimpleLayout")) {
            return new SimpleLayout();
        } else if (input.equals("XmlLayout")) {
            return new XmlLayout();
        }
    return null;
    }
}
