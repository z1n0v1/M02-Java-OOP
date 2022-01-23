import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] data = reader.readLine().split("\\s+");
            String pizzaName = data[1];
            int numToppings = Integer.parseInt(data[2]);
            Pizza pizza = new Pizza(pizzaName, numToppings);

            data = reader.readLine().split("\\s+");
            String flourType = data[1];
            String bakingMethod = data[2];
            int weight = Integer.parseInt(data[3]);
            pizza.setDough(new Dough(flourType, bakingMethod, weight));

            String input;
            while (!"END".equals(input = reader.readLine())) {
                data = input.split("\\s+");
                String toppingType = data[1];
                weight = Integer.parseInt(data[2]);
                pizza.addTopping(new Topping(toppingType, weight));
            }
            System.out.println(pizza);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
