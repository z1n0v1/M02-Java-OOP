public abstract class Food {
    private Integer quantity;

    public Food(Integer quantity) {
        setQuantity(quantity);
    }

    public final Integer getQuantity() {
        return quantity;
    }

    private void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
