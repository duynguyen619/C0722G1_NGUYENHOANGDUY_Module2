package ss7_abstractclas_interface.resizeable.model;

public class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {

        super(3);
    }

    public Circle(double radius) {
        super(3);
        this.radius = radius;
    }

    public Circle(String color, double radius, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return " Một vòng tròn có bán kính = "
                + getRadius()
                + " , đó là một lớp con của "
                + super.toString();
    }


    public void resize(double percentage) {
        this.radius += this.radius * percentage / 100;
    }
}
