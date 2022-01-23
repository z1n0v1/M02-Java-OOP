import java.io.Serializable;

public class Seat implements Car, Serializable {
        private String model, color;
        private Integer horsePower;
        private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String produced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = produced;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    public String countryProduced() {
        return countryProduced;
    }
}
