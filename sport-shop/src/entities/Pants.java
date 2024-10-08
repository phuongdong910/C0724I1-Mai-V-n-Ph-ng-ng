package entities;

public class Pants extends Product {
    private String size;          // Kích thước quần
    private String fabric;        // Chất liệu vải
    private String type;          // Loại quần (ví dụ: quần dài, quần short)

    public Pants(Builder builder) {
        super(builder);
        this.size = builder.size;
        this.fabric = builder.fabric;
        this.type = builder.type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Builder extends Product.Builder<Builder> {
        private String size;
        private String fabric;
        private String type;

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder setFabric(String fabric) {
            this.fabric = fabric;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        @Override
        public Pants build() {
            return new Pants(this);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Pants{" +
                "size='" + size + '\'' +
                ", fabric='" + fabric + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
    @Override
    public String toCSV() { return super.toCSV() + "," + size + "," + fabric + "," + type;
    }


}
