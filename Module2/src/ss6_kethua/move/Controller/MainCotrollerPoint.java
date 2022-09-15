package ss6_kethua.move.Controller;

import ss6_kethua.move.Model.MoveablePoint;
import ss6_kethua.move.Model.Point;

public class MainCotrollerPoint {
    public static void main(String[] args) {

        Point point = new Point(1, 2);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint(1, 3, 2f, 5f);
        moveablePoint.move();
        System.out.println(moveablePoint);

    }
}
