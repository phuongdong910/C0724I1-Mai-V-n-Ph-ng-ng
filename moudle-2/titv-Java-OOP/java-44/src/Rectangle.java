public class Rectangle  extends Shape{
    private double width;
    private  double height;

    public Rectangle(Coodinate coodinate, double width, double height) {

        super(coodinate);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double CaculateArea() {
        return this.width * this.height;
    }
}
