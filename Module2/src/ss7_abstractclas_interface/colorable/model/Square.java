package ss7_abstractclas_interface.colorable.model;

public class Square extends Shape {
    private double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return side * 4;
    }


    public void howToColor() {
        System.out.println("Đổ đầy hình vuông");
    }

    @Override
    public String toString() {
        return "Một hình vuông với bên="
                + getSide()
                + ", đó là một lớp con của "
                + super.toString();
    }

    @Override
    public void resize(double percentage) {

    }
}
