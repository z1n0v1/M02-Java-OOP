import java.text.DecimalFormat;

public class Cat extends Feline {
    private String name, breed;

    public Cat(String animalName, Double animalWeight,
               String livingRegion, String breed) {
        super(animalName, "Cat", animalWeight, livingRegion);
        setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eat(Food food) {
        addFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat decimal = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(),
                getBreed(), decimal.format(getAnimalWeight()),getLivingRegion(), getFoodEaten());
    }
}
