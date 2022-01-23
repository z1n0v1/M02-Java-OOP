import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        setLivingRegion(livingRegion);
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimal = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]", getAnimalType(),
                 getAnimalName(), decimal.format(getAnimalWeight()),getLivingRegion(), getFoodEaten());
    }
}
