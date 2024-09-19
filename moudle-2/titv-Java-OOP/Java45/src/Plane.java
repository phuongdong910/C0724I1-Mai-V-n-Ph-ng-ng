public class Plane extends Vehicle {
    private String fuelType;

    public Plane(String manufacturerName, String countryName, String vehicleName, String manufacturer, String fuelType) {
        super(manufacturerName, countryName, vehicleName, manufacturer);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public double getSpeed() {
        return 1000;
    }

    public  void takeOff(){
        System.out.println("Take off...");
    }
    public  void land(){
        System.out.println("Landing...");
    }
}
