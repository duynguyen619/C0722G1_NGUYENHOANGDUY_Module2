package ss7_abstractclas_interface.resizeable.model;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
        super(3);
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length) {
        super(3);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double side, String color, boolean filled) {
        super(3);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }


    public void resize(double percentage) {
        this.width += this.width * percentage / 100;
        this.length += this.length * percentage / 100;
    }

    public String toString() {
        return " Một hình chữ nhật có chiều rộng = " + getWidth()
                + " và chiều dài = " + getLength()
                + " , đó là một lớp con của "
                + super.toString();
    }
}
