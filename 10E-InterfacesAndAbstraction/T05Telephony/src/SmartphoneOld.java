import java.util.List;
import java.util.regex.Pattern;

public class SmartphoneOld implements Callable, Browsable {
    private List<String> numbers, urls;
    private int numNumber, numUrl;

    public SmartphoneOld(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
        numNumber = 0;
        numUrl = 0;
    }


    @Override
    public String browse() {
        if(numUrl == urls.size()) return null;
        String url = urls.get(numUrl);
        numUrl++;
        if(Pattern.compile("[0-9]").matcher(url).find()) {
            return "Invalid URL!";
        } else {
            return String.format("Browsing: %s!", url);
        }
    }

    @Override
    public String call() {
        if(numNumber == numbers.size()) return null;
        String number = numbers.get(numNumber);
        numNumber++;
        if(Pattern.compile("[^0-9]").matcher(number).find()) {
            return "Invalid number!";
        } else {
            return String.format("Calling... %s!", number);
        }
    }
}
