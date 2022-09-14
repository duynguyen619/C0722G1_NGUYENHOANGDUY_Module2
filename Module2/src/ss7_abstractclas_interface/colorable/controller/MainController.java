package ss7_abstractclas_interface.colorable.controller;

import ss7_abstractclas_interface.colorable.model.Circle;
import ss7_abstractclas_interface.colorable.model.Rectangle;
import ss7_abstractclas_interface.colorable.model.Shape;
import ss7_abstractclas_interface.colorable.model.Square;

public class MainController {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle("blue",true, 10.0,16.0);
        shapes[1] = new Square(6.0, "yellow", false);
        shapes[2] = new Circle("red",8.0,true);

        for (Shape shape : shapes){
            System.out.println(shape);
            if (shape instanceof Square){
                ((Square) shape).howToColor();
            }
        }
    }
}