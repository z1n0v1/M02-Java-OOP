import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentsRepository repo = new StudentsRepository();

        String input;
        while (!"Exit".equals(input = scanner.nextLine())) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "Create": {
                    String name = command[1];
                    int age = Integer.parseInt(command[2]);
                    double grade = Double.parseDouble(command[3]);
                    repo.add(new Student(name, age, grade));
                    break;
                }
                case "Show": {
                    String name = command[1];
                    Student student = repo.get(name);
                    if(student != null)
                        System.out.println(student);
                    break;
                }
            }
        }
    }
}
