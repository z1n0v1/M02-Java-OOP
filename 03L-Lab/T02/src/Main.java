import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Point bottomLeft = new Point(coordinates[0], coordinates[1]),
                topRight = new Point(coordinates[2], coordinates[3]);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            int[] checkPoint = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Point point = new Point(checkPoint[0], checkPoint[1]);
            System.out.println(rectangle.contains(point));
        }
    }
}
