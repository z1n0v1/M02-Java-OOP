import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");
            String animalType = data[0];
            String animalName = data[1];
            Double animalWeight = Double.parseDouble(data[2]);
            String livingRegion = data[3];
            Animal animal = null;

            switch (animalType) {
                case "Mouse":
                    animal = new Mouse(animalName, animalWeight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalWeight, livingRegion);
                    break;
                case "Cat":
                    String breed = data[4];
                    animal = new Cat(animalName, animalWeight, livingRegion, breed);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalWeight, livingRegion);
                    break;
            }
            System.out.println(animal.makeSound());
            data = reader.readLine().split("\\s+");
            String foodType = data[0];
            Integer quantity = Integer.parseInt(data[1]);
            try {
                switch (foodType) {
                    case "Vegetable":
                        animal.eat(new Vegetable(quantity));
                        break;
                    case "Meat":
                        animal.eat(new Meat(quantity));
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            animals.add(animal);
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
