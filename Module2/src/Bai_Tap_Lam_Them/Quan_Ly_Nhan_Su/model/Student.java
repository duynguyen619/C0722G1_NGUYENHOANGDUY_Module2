package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model;

import java.time.LocalDate;

public class Student extends Personnel {
    private double point;
    private String nameClass;


    public Student(String id, String name, LocalDate dateOfBirth, String gender, double point, String nameClass) {
        super(id, name, dateOfBirth, gender);
        this.point = point;
        this.nameClass = nameClass;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", super.toString(), point, nameClass);
    }
}
