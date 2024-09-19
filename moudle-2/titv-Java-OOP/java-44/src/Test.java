public class Test {
    public static void main(String[] args) {
        Coodinate c1 = new Coodinate(4, 10);
        Coodinate c2 =  new Coodinate(7, 15);
        Coodinate c3 =  new Coodinate(18, 3);

        Shape s1 = new Dot(c1);
        Shape s2 = new Circle(c2, 15);
        Shape s3 = new Rectangle(c3, 16, 20);

        System.out.println( "Area of dot: " + s1.CaculateArea());
        System.out.println("Area of circle: " + s2.CaculateArea());
        System.out.println("Area of rectangle: " + s3.CaculateArea());
    }


}
