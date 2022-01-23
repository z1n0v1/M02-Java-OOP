import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(data[1]);
        double litersPerKm = Double.parseDouble(data[2]);
        Car car = new Car(fuelQuantity, litersPerKm);

        data = reader.readLine().split("\\s+");
        fuelQuantity = Double.parseDouble(data[1]);
        litersPerKm = Double.parseDouble(data[2]);
        Truck truck = new Truck(fuelQuantity, litersPerKm);

        DecimalFormat decimal = new DecimalFormat("#.##");
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] command = reader.readLine().split("\\s+");

            if(command[0].equals("Drive")) {
                double distance = Double.parseDouble(command[2]);
                if(command[1].equals("Car")) {
                    if (car.drive(distance)) {
                        System.out.printf("Car travelled %s km%n", decimal.format(distance));
                    } else {
                        System.out.println("Car needs refueling");
                    }
                } else {
                    if (truck.drive(distance)) {
                        System.out.printf("Truck travelled %s km%n", decimal.format(distance));
                    } else {
                        System.out.println("Truck needs refueling");
                    }
                }
            } else {
                double liters = Double.parseDouble(command[2]);
                if (command[1].equals("Car")) {
                    car.refuel(liters);

                } else {
                    truck.refuel(liters);
                }
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
    }
}
