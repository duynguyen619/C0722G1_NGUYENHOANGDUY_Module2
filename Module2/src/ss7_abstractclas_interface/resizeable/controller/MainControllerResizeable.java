package ss7_abstractclas_interface.resizeable.controller;

import ss7_abstractclas_interface.resizeable.model.Circle;
import ss7_abstractclas_interface.resizeable.model.Rectangle;
import ss7_abstractclas_interface.resizeable.model.Shape;
import ss7_abstractclas_interface.resizeable.model.Square;


public class MainControllerResizeable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5);
        shapes[1] = new Rectangle(3, 5);
        shapes[2] = new Square(3);


        for (Shape shape : shapes) {
            shape.resize(Math.floor((Math.random()*100)));
        }

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
