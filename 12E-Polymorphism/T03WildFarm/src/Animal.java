import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName, animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        setAnimalName(animalName);
        setAnimalType(animalType);
        setAnimalWeight(animalWeight);
        foodEaten = 0;
    }

    public String getAnimalName() {
        return animalName;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    private void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void addFoodEaten(int foodQuantity) {
        foodEaten += foodQuantity;
    }

    public abstract String makeSound();

    public abstract void eat(Food food);


}
