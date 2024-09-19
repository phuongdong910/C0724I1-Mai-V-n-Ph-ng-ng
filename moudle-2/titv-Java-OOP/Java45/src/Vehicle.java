public abstract class Vehicle extends Manufacturer {
    protected String vehicleName;
    protected String manufacturer;

    public Vehicle(String manufacturerName, String countryName, String vehicleName, String manufacturer) {
        super(manufacturerName, countryName);
        this.vehicleName = vehicleName;
        this.manufacturer = manufacturer;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public  void begin(){
        System.out.println("Begin....");
    }
    public  void speedUp(){
        System.out.println("Speep up...");
    }
    public  void stop(){
        System.out.println("Stop...");
    }
    public abstract double getSpeed();
}


