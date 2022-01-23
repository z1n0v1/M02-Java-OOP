import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Identifiable> people = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");

            if(data.length == 3) {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                people.add(new Citizen(name, age, id));
            }
            else if (data.length == 2) {
                String model = data[0];
                String id = data[1];
                people.add(new Robot(id, model));
            }
        }
        String lastIdDigits = reader.readLine();
        int lastIdDigitsLength = lastIdDigits.length();
        for (Identifiable person : people) {
            String id = person.getId();
            if(id.substring(id.length() - lastIdDigitsLength, id.length()).equals(lastIdDigits))
                System.out.println(id);
        }
    }
}
