public class Zebra extends Mammal {
    public Zebra(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Zebra", animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }

    @Override
    public void eat(Food food) {
        if(!(food instanceof Vegetable))
            throw new IllegalArgumentException(
                    "Zebras are not eating that type of food!");
        // Add the feeding algorithm..
        addFoodEaten(food.getQuantity());
    }
}
