public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + 1.4, tankCapacity);
    }

    public void driveEmpty(double distance) {
        if (distance * (getLitersPerKm() - 1.4) > getFuelQuantity())
            throw new IllegalArgumentException(
                    String.format("%s needs refueling",
                            this.getClass().getSimpleName()));
        setFuelQuantity(getFuelQuantity() - distance * (getLitersPerKm() - 1.4));
    }
}
