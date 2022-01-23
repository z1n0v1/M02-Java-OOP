public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + 1.6);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
