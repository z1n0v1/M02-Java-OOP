import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(data[0]);
        int numDays = Integer.parseInt(data[1]);
        Season season = Season.valueOf(data[2]);
        Discount discount = Discount.valueOf(data[3]);
        System.out.printf("%.2f",
                PriceCalculator.calculatePrice(pricePerDay, numDays, season, discount));
    }
}
