import java.text.DecimalFormat;

public class Person {
    private String firstName, lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        DecimalFormat format = new DecimalFormat("#.0#########");
        return String.format("%s %s gets %s leva", firstName, lastName, format.format(salary));
    }

    public void increaseSalary(double precentage) {
        if(this.getAge() < 30)
            this.setSalary(this.getSalary() + this.getSalary() * precentage/200);
        else
            this.setSalary(this.getSalary() + this.getSalary() * precentage/100);
    }
}
