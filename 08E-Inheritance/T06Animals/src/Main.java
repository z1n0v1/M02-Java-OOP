import animals.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("Beast!")) {
            String animalType = input;
            String[] data = reader.readLine().split("\\s+");
            try {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String gender = data[2];
                switch (animalType) {
                    case "Dog":
                        animals.add(new Dog(name, age, gender));
                        break;
                    case "Cat":
                        animals.add(new Cat(name, age, gender));
                        break;
                    case "Frog":
                        animals.add(new Frog(name, age, gender));
                        break;
                    case "Kitten":
                        animals.add(new Kitten(name, age, gender));
                        break;
                    case "Tomcat":
                        animals.add(new Tomcat(name, age, gender));
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }
            input = reader.readLine();
        }
        animals.forEach(System.out::println);
    }
}
