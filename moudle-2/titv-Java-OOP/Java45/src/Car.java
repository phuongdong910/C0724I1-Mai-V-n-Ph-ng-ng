public class Car extends Vehicle{
String fuelType;

    public Car(String manufacturerName, String countryName, String vehicleName, String manufacturer, String fuelType) {
        super("BMW", manufacturerName);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    @Override
    public  double getSpeed(){
        return 60;
    }
}
