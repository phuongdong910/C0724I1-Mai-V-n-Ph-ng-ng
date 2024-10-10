package entities;

public class ImportedMobile extends Mobile {
    private String importCountry;
    private String status; // "new" or "used"

    public ImportedMobile(String id, String name, double price, int quantity, String manufacturer,
                          String importCountry, String status) {
        super(id, name, price, quantity, manufacturer);
        this.importCountry = importCountry;
        this.status = status;
    }

    public String getImportCountry() {
        return importCountry;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Import Country: %s, Status: %s",
                importCountry, status);
    }

    @Override
    public String toCSV() {
        return String.join(",", getId(), getName(), String.valueOf(getPrice()),
                String.valueOf(getQuantity()), getManufacturer(),
                importCountry, status);
    }
}
