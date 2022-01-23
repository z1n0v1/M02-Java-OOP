public abstract class Animal {
    private String name, favouriteFood;

    protected Animal(String name, String favouriteFood) {
        setName(name);
        setFavouriteFood(favouriteFood);
    }

    public final String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public final String getFavouriteFood() {
        return favouriteFood;
    }

    protected void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s", getName(), getFavouriteFood());
    }
}
