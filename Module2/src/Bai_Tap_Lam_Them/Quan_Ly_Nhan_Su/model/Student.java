package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model;

public class Student extends Personnel {
    private final double point;
    private final String nameClass;


    public Student(int id, String name, String dateOfBirth, String gender, double point, String nameClass) {
        super(id, name, dateOfBirth, gender);
        this.point = point;
        this.nameClass = nameClass;
    }


    @Override
    public String toString() {
        return "Student{" +
                "point=" + point +
                ", nameClass='" + nameClass + '\'' +
                "} " + super.toString();
    }
}
