package ss6_kethua.circle_cylinder.model;

public class Circle {
    private double radius = 2.0;
    private String color = "Black";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return (this.radius * this.radius * Math.PI);
    }

    @Override
    public String toString() {
        return "radius = " + getRadius() +
                ", color ='" + getColor() + '\'' +
                ", area ='" + getArea() + '\'';
    }
}
