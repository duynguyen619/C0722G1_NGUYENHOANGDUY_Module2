package ss7_abstractclas_interface.resizeable.model;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }


    public void resize(double percentage) {
        setSide(percentage);
    }


    public String toString() {
        return "Một hình vuông với bên="
                + getSide()
                + ", đó là một lớp con của "
                + super.toString();
    }
}
