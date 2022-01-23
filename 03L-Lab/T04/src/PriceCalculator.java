public class PriceCalculator {
    public static double calculatePrice(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        return (pricePerDay - (pricePerDay * discount.getValue() / 100)) * season.getValue() * numberOfDays;
    }
}
