import java.util.List;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers, urls;
    private int numNumber, numUrl;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
        numNumber = 0;
        numUrl = 0;
    }


    @Override
    public String browse() {

        StringBuilder builder = new StringBuilder();

        urls.forEach(url -> {
            if (Pattern.compile("[0-9]", Pattern.MULTILINE).matcher(url).find() || url.trim().length() == 0) {
                builder.append(String.format("Invalid URL!%n"));
            } else {
                builder.append(String.format("Browsing: %s!%n", url));
            }
        });
        return builder.toString();
    }

        /*
        if(numUrl == urls.size()) return null;
        String url = urls.get(numUrl);
        numUrl++;
        if(Pattern.compile("[0-9]").matcher(url).find()) {
            return "Invalid URL!";
        } else {
            return String.format("Browsing: %s!", url);
        }
*/


    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();

        numbers.forEach(number -> {
            if (Pattern.compile("[^0-9]").matcher(number).find() || number.trim().length() == 0) {
                builder.append(String.format("Invalid number!%n"));
            } else {
                builder.append(String.format("Calling... %s%n", number));
            }
        });
        return builder.toString();
    }
   /*
        if(numNumber == numbers.size()) return null;
        String number = numbers.get(numNumber);
        numNumber++;
        if(Pattern.compile("[^0-9]").matcher(number).find()) {
            return "Invalid number!";
        } else {
            return String.format("Calling... %s!", number);
        }

    */

}
/*
Pattern.compile(""^[0-9]+$", Pattern.MULTILINE);
Iliya
използвам за адреса
Iliya
за телефона де
Iliya
Iliya Yanev
за адреса ^\D+$
 */