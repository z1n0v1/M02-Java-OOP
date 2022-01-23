public abstract class Vehicle {
    private double fuelQuantity, litersPerKm, distanceTraveled, tankCapacity;

    public Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setLitersPerKm(litersPerKm);
        setTankCapacity(tankCapacity);
        distanceTraveled = 0;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        if (tankCapacity < 0)
            throw new IllegalArgumentException("Fuel must be a positive number");
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0)
            throw new IllegalArgumentException("Fuel must be a positive number");
        this.fuelQuantity = fuelQuantity;
    }

    protected double getLitersPerKm() {
        return litersPerKm;
    }

    private void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    public final double getFuelQuantity() {
        return fuelQuantity;
    }

    public void drive(double distance) {
        if (distance * litersPerKm > fuelQuantity)
            throw new IllegalArgumentException(
                    String.format("%s needs refueling",
                            this.getClass().getSimpleName()));
        fuelQuantity -= distance * litersPerKm;
    }

    public void refuel(double liters) {
        if (fuelQuantity + liters > tankCapacity)
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        fuelQuantity += liters;
    }

}
