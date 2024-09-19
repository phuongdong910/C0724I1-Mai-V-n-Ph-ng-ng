public class FootballField {
    private String name;
    private String address;
    private double price;
    private boolean isAvailable;

    public FootballField(String name, String address, double price, boolean isAvailable) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  void setAddress(String address){
        this.address = address;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public String toString(){
        return " Sân bóng[Tên: " + name + ",Địa chỉ: " + address + ", Giá: " + price + ", Tình trạng: " + (isAvailable? "Còn trống" : "Đã đặt" + "]" );
    }

}
