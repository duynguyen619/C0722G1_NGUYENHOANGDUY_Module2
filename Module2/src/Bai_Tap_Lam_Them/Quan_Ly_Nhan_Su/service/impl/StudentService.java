package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.impl;


import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model.Student;
import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.IStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudent {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Student> studentList = new ArrayList<>() ;


    static {
        studentList.add(new Student(1, "Nguyễn Văn B", "2001", "Nam", 10, "C06"));
        studentList.add(new Student(2, "Nguyễn Văn C", "1999", "Nữ", 10, "C06"));
        studentList.add(new Student(3, "Nguyễn Văn A", "1998", "Nữ", 10, "C06"));
    }

    public void sortStudent() {
        for (int i = 1; i < studentList.size(); i++) {
            Student temp1 = studentList.get(i);
            int j;
            for (j = i - 1; j >= 0 && studentList.get(j).getName().compareTo(temp1.getName()) > 0; j--) {
                studentList.set(j + 1, studentList.get(j));
            }
            studentList.set(j + 1, temp1);
        }
        System.out.println("Đã sắp xếp!");
    }

    @Override
    public void displayAllStudent() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void addStudent(){
        Student student = this.infoStudent();
        studentList.add(student);
        System.out.println("Thêm mới học sinh thành công");
    }

    @Override
    public void removeStudent(){
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + student.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                studentList.remove(student);
                System.out.println("Xóa thành công!");
            }
        }
    }

    private Student findStudent() {
        System.out.println("Mời bạn nhập vào id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student infoStudent() {
        System.out.print("Mời bạn nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        return new Student(id, name, dateOfBirth, gender, point, nameClass);
    }

    public void search() {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        int count = 0;
        for (Student student : studentList) {
            if (name.contains(student.getName())) {
                System.out.println(student);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có tên học sinh");
        }
    }
}
