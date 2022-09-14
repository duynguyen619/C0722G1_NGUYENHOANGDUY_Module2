package ss7_kethua.circle_cylinder.controller;

import ss7_kethua.circle_cylinder.model.Circle;

public class MainControllerCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        Circle circle1 = new Circle(3.0, "Blue");
        System.out.println(circle1);
    }
}
