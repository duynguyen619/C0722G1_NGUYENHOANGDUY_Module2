package ss9_ArarayLisst.ArrayList;

public class TestArrayList {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(1, "Duy");
        Student b = new Student(2, "Huy");
        Student c = new Student(3, "Hải");



        MyArraylist<Student> studentMyArrraylist = new MyArraylist<>();
        studentMyArrraylist.add(a);
        studentMyArrraylist.add(b);
        studentMyArrraylist.add(c);
        for (int i = 0; i < studentMyArrraylist.size(); i++) {
            Student student = (Student) studentMyArrraylist.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }
    }
}
