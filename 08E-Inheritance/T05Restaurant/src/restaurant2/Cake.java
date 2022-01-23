package restaurant2;

import java.math.BigDecimal;

public class Cake extends Dessert {
    private static final double CAKE_GRAMS = 250.0;
    private static final double CAKE_CALORIES = 1000.0;
    private static final BigDecimal CAKE_PRICE = new BigDecimal("5");

    public Cake(String name, BigDecimal price, double grams, double calories) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }
}

