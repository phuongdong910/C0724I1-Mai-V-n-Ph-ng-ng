package entities;

public class SportsEquipment extends Product {
    private String equipmentType; // Loại dụng cụ
    private String size;           // Kích thước
    private String material;       // Chất liệu
    private String purpose;        // Mục đích sử dụng
    private Double weight;         // Trọng lượng

    public SportsEquipment(Builder builder) {
        super(builder);
        this.equipmentType = builder.equipmentType;
        this.size = builder.size;
        this.material = builder.material;
        this.purpose = builder.purpose;
        this.weight = builder.weight;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public static class Builder extends Product.Builder<Builder> {
        private String equipmentType;
        private String size;
        private String material;
        private String purpose;
        private Double weight;

        public Builder setEquipmentType(String equipmentType) {
            this.equipmentType = equipmentType;
            return this;
        }

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public Builder setPurpose(String purpose) {
            this.purpose = purpose;
            return this;
        }

        public Builder setWeight(Double weight) {
            this.weight = weight;
            return this;
        }

        @Override
        public SportsEquipment build() {
            return new SportsEquipment(this);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "SportsEquipment{" +
                "equipmentType='" + equipmentType + '\'' +
                ", size='" + size + '\'' +
                ", material='" + material + '\'' +
                ", purpose='" + purpose + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public String toCSV() { return super.toCSV() + "," + equipmentType + "," + size + "," + material + "," + purpose + "," + weight;
    }

}
