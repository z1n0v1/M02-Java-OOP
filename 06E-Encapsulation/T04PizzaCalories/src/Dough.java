public class Dough {
    private String flourType, bakingTechnique;
    private double weight, flourTypeModifier, bakingTechniqueModifier;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {

        switch (flourType) {
            case "White":
                flourTypeModifier = 1.5;
                break;
            case "Wholegrain":
                flourTypeModifier = 1.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Homemade":
                bakingTechniqueModifier = 1.0;
                break;
            case "Crispy":
                bakingTechniqueModifier = 0.9;
                break;
            case "Chewy":
                bakingTechniqueModifier = 1.1;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2.0 * flourTypeModifier * bakingTechniqueModifier * weight;
    }
}
