public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String toString() {
        return String.format("%s is %s years old. %s", name, age,
                grade >= 5 ? "Excellent student." :
                        grade >= 3.50 ? "Average student." :
                                "Very nice person.");
    }

    public String getName() {
        return this.name;
    }

}
