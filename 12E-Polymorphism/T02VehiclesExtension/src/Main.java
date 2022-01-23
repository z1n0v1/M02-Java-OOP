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
        double tankCapacity = Double.parseDouble(data[3]);
        Car car = new Car(fuelQuantity, litersPerKm, tankCapacity);

        data = reader.readLine().split("\\s+");
        fuelQuantity = Double.parseDouble(data[1]);
        litersPerKm = Double.parseDouble(data[2]);
        tankCapacity = Double.parseDouble(data[3]);
        Truck truck = new Truck(fuelQuantity, litersPerKm, tankCapacity);

        data = reader.readLine().split("\\s+");
        fuelQuantity = Double.parseDouble(data[1]);
        litersPerKm = Double.parseDouble(data[2]);
        tankCapacity = Double.parseDouble(data[3]);
        Bus bus = new Bus(fuelQuantity, litersPerKm, tankCapacity);

        DecimalFormat decimal = new DecimalFormat("#.##");
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] command = reader.readLine().split("\\s+");

            try {
                switch (command[0]) {
                    case "Drive": {
                        double distance = Double.parseDouble(command[2]);
                        switch (command[1]) {
                            case "Car":
                                car.drive(distance);
                                System.out.printf("Car travelled %s km%n", decimal.format(distance));
                                break;
                            case "Truck":
                                truck.drive(distance);
                                System.out.printf("Truck travelled %s km%n", decimal.format(distance));
                                break;
                            case "Bus":
                                bus.drive(distance);
                                System.out.printf("Bus travelled %s km%n", decimal.format(distance));
                                break;
                        }
                        break;
                    }
                    case "DriveEmpty": {
                        // only buses can drive empty
                        double distance = Double.parseDouble(command[2]);
                        bus.driveEmpty(distance);
                        System.out.printf("Bus travelled %s km%n", decimal.format(distance));
                        break;
                    }
                    case "Refuel": {
                        double liters = Double.parseDouble(command[2]);
                        if (liters <= 0) throw new IllegalArgumentException("Fuel must be a positive number");
                        switch (command[1]) {
                            case "Car":
                                car.refuel(liters);
                                break;
                            case "Truck":
                                truck.refuel(liters);
                                break;
                            case "Bus":
                                bus.refuel(liters);
                                break;
                        }
                        break;
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
    }
}
