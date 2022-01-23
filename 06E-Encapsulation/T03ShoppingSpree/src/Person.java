import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public String toString() {
        if (products.isEmpty()) {
            return getName() + " – Nothing bought";
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(getName()).append(" - ");
            for (int i = 0; i < products.size() - 1; i++) {
                builder.append(products.get(i).getName()).append(", ");
            }
            builder.append(products.get(products.size() - 1).getName());
            return builder.toString();
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be an empty");
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) throw new IllegalArgumentException("Money cannot be a negative");
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > money) throw new IllegalArgumentException(
                        String.format("%s can't afford %s", getName(), product.getName()));
        money -= product.getCost();
        products.add(product);
    }


}
