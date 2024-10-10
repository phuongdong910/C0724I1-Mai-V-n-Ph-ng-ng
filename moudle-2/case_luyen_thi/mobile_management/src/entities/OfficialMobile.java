package entities;

public class OfficialMobile extends Mobile {
    private int warrantyPeriod; // in months
    private String warrantyScope; // "domestic" or "international"

    public OfficialMobile(String id, String name, double price, int quantity, String manufacturer,
                          int warrantyPeriod, String warrantyScope) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    // Getters and Setters
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Warranty Period: %d months, Warranty Scope: %s",
                warrantyPeriod, warrantyScope);
    }

    @Override
    public String toCSV() {
        return String.join(",", getId(), getName(), String.valueOf(getPrice()),
                String.valueOf(getQuantity()), getManufacturer(),
                String.valueOf(warrantyPeriod), warrantyScope);
    }
}
