import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Buyer> buyers = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] data = reader.readLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            if(data.length == 3) {
                String group = data[2];
                if(!buyers.containsKey(name))
                    buyers.put(name, new Rebel(name, age, group));
            } else {
                String id = data[2];
                String birthDate = data[3];
                if(!buyers.containsKey(name))
                    buyers.put(name, new Citizen(name, age, id, birthDate));
            }
        }
        String name;
        while (!"End".equals(name = reader.readLine())) {
            if(buyers.containsKey(name))
                buyers.get(name).buyFood();
        }

        int sum = buyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(sum);
    }
}
