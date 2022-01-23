public class Topping {
    private String toppingType;
    private double weight, modifier;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier = 0.9;
                break;
            default:
                throw new IllegalArgumentException(String.format(
                        "Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 | weight > 50) throw new IllegalArgumentException(String.format(
                "%s weight should be in the range [1..50].", toppingType));
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * modifier * weight;
    }
}
