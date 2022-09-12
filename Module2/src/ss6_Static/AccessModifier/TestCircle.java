package ss6_Static.AccessModifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.printf(String.valueOf(circle.getRadius()));
        System.out.printf(String.valueOf(circle.getArea()));

        Circle circle1 = new Circle();
        circle1.setRadius(2);
        System.out.printf(String.valueOf(circle.getRadius()));
        System.out.printf(String.valueOf(circle.getArea()));
    }
}
