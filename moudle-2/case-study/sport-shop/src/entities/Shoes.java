package entities;

public class Shoes extends Product {
    private int size;
    private String style;
    private String soleMaterial;

    private Shoes(Builder builder) {
        super(builder);
        this.size = builder.size;
        this.style = builder.style;
        this.soleMaterial = builder.soleMaterial;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSoleMaterial() {
        return soleMaterial;
    }

    public void setSoleMaterial(String soleMaterial) {
        this.soleMaterial = soleMaterial;
    }

    public static class Builder extends Product.Builder<Builder> {
        private int size;
        private String style;
        private String soleMaterial;

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setStyle(String style) {
            this.style = style;
            return this;
        }

        public Builder setSoleMaterial(String soleMaterial) {
            this.soleMaterial = soleMaterial;
            return this;
        }

        @Override
        public Shoes build() {
            return new Shoes(this);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Shoes{" + "size='" + size + '\'' +
                "style='" + style + '\'' +
                ", soleMaterial='" + soleMaterial + '\'' +
                '}';
    }
    @Override
    public String toCSV() { return super.toCSV() + "," + size + "," + style + "," + soleMaterial;
    }
}
