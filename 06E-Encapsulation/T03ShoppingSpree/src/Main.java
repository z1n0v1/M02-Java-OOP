import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();

        try {

            String[] peopleIn = reader.readLine().split("\\;");
            for (String personData : peopleIn) {
                String[] data = personData.split("\\=");
                people.putIfAbsent(data[0], new Person(data[0], Double.parseDouble(data[1])));
            }

            String[] productsIn = reader.readLine().split("\\;");
            for (String productData : productsIn) {
                String[] data = productData.split("\\=");
                products.putIfAbsent(data[0], new Product(data[0], Double.parseDouble(data[1])));
            }

            String input;
            while (!"END".equals(input = reader.readLine())) {
                String[] data = input.split("\\s+");
                String personName = data[0], productName = data[1];
                try {
                    people.get(personName).buyProduct(products.get(productName));
                    System.out.printf("%s bought %s%n", personName, productName);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            people.values().forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
