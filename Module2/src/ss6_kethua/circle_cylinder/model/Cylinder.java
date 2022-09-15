package ss6_kethua.circle_cylinder.model;

public class Cylinder extends Circle {
    private double heigth;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double heigth) {
        super(radius, color);
        this.heigth = heigth;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public double getVolume() {
        return getArea() * this.heigth;
    }

    @Override
    public String toString() {
        return super.toString() +
                " heigth = " + getHeigth() +
                " volume " + getVolume();
    }
}
