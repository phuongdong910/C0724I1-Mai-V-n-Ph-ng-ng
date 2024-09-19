public abstract class Shape {
    protected Coodinate coodinate;

    public Shape(Coodinate coodinate) {
        this.coodinate = coodinate;
    }

    public Coodinate getCoodinate() {
        return coodinate;
    }

    public void setCoodinate(Coodinate coodinate) {
        this.coodinate = coodinate;
    }

    public abstract double CaculateArea();
}
