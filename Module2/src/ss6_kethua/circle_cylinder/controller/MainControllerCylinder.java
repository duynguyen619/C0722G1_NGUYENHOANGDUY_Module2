package ss6_kethua.circle_cylinder.controller;

import ss6_kethua.circle_cylinder.model.Cylinder;

public class MainControllerCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        Cylinder cylinder1 = new Cylinder(2.0, "Red", 4.0);
        System.out.println(cylinder1);
    }
}
