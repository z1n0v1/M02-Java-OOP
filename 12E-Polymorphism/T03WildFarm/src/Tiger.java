public class Tiger extends Feline {
    private String livingRegion;

    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, "Tiger", animalWeight, livingRegion);
    }


    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eat(Food food) {
        if(!(food instanceof Meat))
            throw new IllegalArgumentException(
                    "Tigers are not eating that type of food!");
        // Add the feeding algorithm..
        addFoodEaten(food.getQuantity());
    }
}
