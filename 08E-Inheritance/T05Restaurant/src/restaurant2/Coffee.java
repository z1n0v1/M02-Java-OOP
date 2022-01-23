package restaurant2;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {
    private static final double COFFEE_MILLILITERS = 50;
    private static final BigDecimal COFFEE_PRICE = new BigDecimal("3.50");
    private double caffeine;
    public Coffee(String name, BigDecimal price, double milliliters, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        setCaffeine(caffeine);
    }

    public double getCaffeine() {
        return caffeine;
    }

    private void setCaffeine(double caffeine) {
        this.caffeine = caffeine;
    }
}
