package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[][] galaxy;
    private static int rows, cols;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            rows = dimestions[0];
            cols = dimestions[1];

            galaxy = new int[rows][cols];

            populateGalaxy();

            String command = scanner.nextLine();
            long sum = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] jediCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int evilRow = evilCoordinates[0];
                int evilCol = evilCoordinates[1];

                destroyStarsFrom(evilRow, evilCol);

                int jediRow = jediCoordinates[0];
                int jediCol = jediCoordinates[1];

                sum += gatherStarsFrom(jediRow, jediCol);

                command = scanner.nextLine();
            }
        System.out.println(sum);
    }

    private static void populateGalaxy() {
        int starValue = 0;
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                galaxy[row][col] = starValue++;
            }
        }
    }

    private static long gatherStarsFrom(int jediRow, int jediCol) {
        int sum = 0;
        while (jediRow >= 0 && jediCol < galaxy[0].length)
        {
            if (jediCol >= 0 && jediRow < galaxy.length)
            {
                sum += galaxy[jediRow][jediCol];
            }

            jediCol++;
            jediRow--;
        }
        return sum;
    }

    private static void destroyStarsFrom(int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0)
        {
            if (evilRow < galaxy.length && evilCol < galaxy[0].length)
            {
                galaxy[evilRow] [evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }
}
