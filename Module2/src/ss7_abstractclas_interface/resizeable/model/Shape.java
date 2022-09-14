package ss7_abstractclas_interface.resizeable.model;

public class Shape extends Resizeable {
    private String color = "green";
    private boolean filled = true;

    public Shape(int i) {

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

    public String toString() {
        return " Một hình dạng với màu sắc của " +
                getColor() + " và "
                + (isFilled() ? " điền " : " Chưa được điền ");
    }


    public void resize(double percentage) {}
}
