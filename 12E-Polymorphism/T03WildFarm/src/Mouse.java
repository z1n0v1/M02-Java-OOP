public class Mouse extends Mammal {
    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Mouse", animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public void eat(Food food) {
        if(!(food instanceof Vegetable))
            throw new IllegalArgumentException(
                    "Mice are not eating that type of food!");
        // Add the feeding algorithm..
        addFoodEaten(food.getQuantity());
    }
}
