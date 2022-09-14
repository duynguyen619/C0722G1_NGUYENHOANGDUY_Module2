package ss7_kethua.circle_cylinder.controller;

import ss7_kethua.circle_cylinder.model.Cylinder;

public class MainControllerCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        Cylinder cylinder1 = new Cylinder(2.0, "Red", 4.0);
        System.out.println(cylinder1);
    }
}
