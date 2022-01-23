public class Car extends Vehicle {
    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + 0.9);
    }


}
