package ss6_Static.Student;

public class Student {
    private String name="John";
    private String classroom="C02";

    public Student(String name, String classroom) {
        this.name = name;
        this.classroom = classroom;

    }


    public String getInfo() {
        return ("Họ và tên: " + name + " Lớp: " + classroom);
    }
}
