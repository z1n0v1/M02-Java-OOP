package animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    private void setName(String name) {
        if (name.trim().isEmpty())
            throw new IllegalArgumentException("Invalid input!");
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Invalid input!");
        this.age = age;
    }

    private void setGender(String gender) {
        if (!gender.equals("Male") && !gender.equals("Female"))
            throw new IllegalArgumentException("Invalid input!");
        this.gender = gender;
    }

    public abstract String produceSound();

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName(), name, age, gender, produceSound());
    }
}
