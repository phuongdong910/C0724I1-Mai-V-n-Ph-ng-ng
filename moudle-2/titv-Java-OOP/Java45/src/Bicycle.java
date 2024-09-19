public class Bicycle extends Vehicle {

    public Bicycle(String manufacturerName, String countryName, String vehicleName, String manufacturer) {
        super(manufacturerName, countryName, vehicleName, manufacturer);
    }

    @Override
    public double getSpeed() {
        return 20;
    }
}