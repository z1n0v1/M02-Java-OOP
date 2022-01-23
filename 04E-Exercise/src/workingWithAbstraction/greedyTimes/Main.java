
package workingWithAbstraction.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static LinkedHashMap<String, LinkedHashMap<String, Long>> bag;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long maxCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        bag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long money = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long quantity = Long.parseLong(safe[i + 1]);

            String item = "";

            if (name.length() == 3) {
                item = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                item = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                item = "Gold";
            }

            if (item.equals("")) {
                continue;
            } else if (maxCapacity < bag.values().stream().map(Map::values)
                    .flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity) {
                continue;
            }

            if (!canAdd(item, quantity))
                continue;

            if (!bag.containsKey(item)) {
                bag.put((item), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(item).containsKey(name)) {
                bag.get(item).put(name, 0L);
            }


            bag.get(item).put(name, bag.get(item).get(name) + quantity);
            if (item.equals("Gold")) {
                gold += quantity;
            } else if (item.equals("Gem")) {
                gems += quantity;
            } else if (item.equals("Cash")) {
                money += quantity;
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> treasures : bag.entrySet()) {
            Long treasureQuantity = treasures.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", treasures.getKey(), treasureQuantity);

            treasures.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(treasure -> System.out.println("##" + treasure.getKey() + " - " + treasure.getValue()));

        }
    }

    public static boolean canAdd(String item, long quantity) {
        long goldSum = bag.containsKey("Gold") ? getSum("Gold") : 0;
        long gemSum = bag.containsKey("Gem") ? getSum("Gem") : 0;
        long cashSum = bag.containsKey("Cash") ? getSum("Cash") : 0;

        if(item.equals("Gem") && goldSum < gemSum + quantity ) {
            return false;
        } else if (item.equals("Cash") && gemSum < cashSum + quantity) {
            return false;
        }
        return true;
    }

    private static long getSum(String treasure) {
    return bag.get(treasure).values().stream().mapToLong(e -> e).sum();
    }
}