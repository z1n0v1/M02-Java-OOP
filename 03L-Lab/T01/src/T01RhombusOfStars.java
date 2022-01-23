import java.util.Scanner;

public class T01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        for (int numStars = 1; numStars <= size ; numStars++) {
            printRow(numStars, size);
        }
        for (int numStars = size - 1; numStars >= 1 ; numStars--) {
            printRow(numStars, size);
        }
    }

    private static void printRow(int numStars, int size) {

        for (int i = 1; i <= size - numStars; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i < numStars; i++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
