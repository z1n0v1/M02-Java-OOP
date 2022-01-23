import java.io.Serializable;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String produced, Double price) {
        super(model, color, horsePower, produced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s sells for %f", getModel(), price);
    }
}
