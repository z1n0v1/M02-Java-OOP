public abstract class Vehicle {
    private double fuelQuantity, litersPerKm, distanceTraveled;

    public Vehicle(double fuelQuantity, double litersPerKm) {
        setFuelQuantity(fuelQuantity);
        setLitersPerKm(litersPerKm);
        distanceTraveled = 0;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    private void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    public final double getFuelQuantity() {
        return fuelQuantity;
    }

    public boolean drive(double distance) {
        if (distance * litersPerKm > fuelQuantity) return false;
        fuelQuantity -= distance * litersPerKm;
        return true;
    }

    public void refuel(double liters) {
        fuelQuantity += liters;
    }

}
