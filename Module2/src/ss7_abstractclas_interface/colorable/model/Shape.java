package ss7_abstractclas_interface.colorable.model;

public class Shape {
    private String color = "green";
    private boolean filled = true;

    public Shape() {

    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }


    public String toString() {
        return " Một hình dạng với màu sắc của " +
                getColor() + " và "
                + (isFilled() ? " điền " : " Chưa được điên ");
    }

    public void resize(double percentage) {

    }
}
