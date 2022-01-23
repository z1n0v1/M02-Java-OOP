import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, List<Birthable>> birthdays = new LinkedHashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Citizen": {
                    String name = command[1];
                    int age = Integer.parseInt(command[2]);
                    String id = command[3];
                    String birthDay = command[4];
                    String year = birthDay.split("\\/")[2];
                    if (!birthdays.containsKey(year))
                        birthdays.put(year, new ArrayList<>());
                    birthdays.get(year).add(new Citizen(name, age, id, birthDay));
                    break;
                }
                case "Pet": {
                    String name = command[1];
                    String birthDay = command[2];
                    String year = birthDay.split("\\/")[2];
                    if (!birthdays.containsKey(year))
                        birthdays.put(year, new ArrayList<>());
                    birthdays.get(year).add(new Pet(name, birthDay));
                    break;
                }
            }
        }
        String year = reader.readLine();
        if(birthdays.containsKey(year)) {
            birthdays.get(year).stream().map(Birthable::getBirthDate).forEach(System.out::println);
        }
    }
}
