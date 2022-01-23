package Cards.T04;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrafficLight[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLight::valueOf).toArray(TrafficLight[]::new);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0 ) {
            for (int i = 0; i < lights.length; i++) {
                System.out.print(lights[i].next() + " ");
                lights[i] = lights[i].next();
            }
            System.out.println();
        }
    }
}
