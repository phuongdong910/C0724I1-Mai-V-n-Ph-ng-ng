package entities;

public abstract class Mobile {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String manufacturer;

    public Mobile(String id, String name, double price, int quantity, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Price: %.2f, Quantity: %d, Manufacturer: %s",
                id, name, price, quantity, manufacturer);
    }

    public abstract String toCSV();
}
