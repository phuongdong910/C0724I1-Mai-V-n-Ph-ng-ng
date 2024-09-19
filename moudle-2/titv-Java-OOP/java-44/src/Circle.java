public class Circle extends Shape{

    private  double radius;


    public Circle(Coodinate coodinate, double radius) {
        super(coodinate);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double CaculateArea() {
        return this.radius *this.radius * Math.PI;
    }
}
