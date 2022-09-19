package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.impl;


import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model.Student;
import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.IStudent;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudent {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Student> studentList = new ArrayList<>();


//    static {
//        studentList.add(new Student(2, "Nguyễn Văn B","2001/06/06", "Nam", 10, "C06"));
//        studentList.add(new Student(1, "Nguyễn Văn C", "1999/03/02", "Nữ", 10, "C06"));
//        studentList.add(new Student(3, "Nguyễn Văn A", "1998/12/04", "Nữ", 10, "C06"));
//    }

    public void sortStudent() {
        for (int i = 1; i < studentList.size(); i++) {
            Student temp1 = studentList.get(i);
            int j;
            for (j = i - 1; j >= 0 && studentList.get(j).getName().compareTo(temp1.getName()) < 0; j--) {
                studentList.set(j + 1, studentList.get(j));
            }
            studentList.set(j + 1, temp1);
        }
        System.out.println("Đã sắp xếp!");
    }

    @Override
    public void displayAllStudent() {
        if (studentList.isEmpty()) {
            System.err.println("Chưa có dữ liệu, mời bạn nhập dữ liệu");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println((1 + i) + ". " + studentList.get(i));
            }
        }
    }

    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        studentList.add(student);
        System.out.println("Thêm mới học sinh thành công");
    }

    @Override
    public void removeStudent() {
        Student student = this.findStudent();
        if (student == null) {
            System.err.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + student.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                studentList.remove(student);
                System.err.println("Xóa thành công!");
            }
        }
    }

    private Student findStudent() {
        System.out.println("Mời bạn nhập vào id cần xóa: ");
        String id = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student infoStudent() {
        String id = "SV-" + (studentList.size() + 1);
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        LocalDate dateNow = LocalDate.now();
        boolean check;
        LocalDate dateOfBirth = null;
        do {
            System.out.println("nhập ngay sinh theo dd/MM/yyyy");
            String day = scanner.nextLine();
            dateOfBirth = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Period periodToNextJavaRelease = Period.between(dateOfBirth, dateNow);
            if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
                System.err.println("bạn đã nhập đúng ");
                break;
            }
            check = false;
            System.err.println("bạn đã nhập sai yêu cầu nhâp lại ");
        } while (!check);
        System.out.print("Mời bạn giới tính: ");
        String gender = "";
        do {
            System.out.println("chọn giới tính " +
                    "\n 1.Nam" +
                    "\n 2.Nữ" +
                    "\n 3.LGBT");
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    gender = "Nam";
                    break;
                case "2":
                    gender = "Nư";
                    break;
                case "3":
                    gender = "LGBT";
                    break;
                default:
                    System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (gender.equals(""));
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
            System.err.println("Không có tên học sinh");
        }
    }

    public void editStudent() {
        displayAllStudent();
        System.out.println("Chọn khách hàng cần sửa ");
        String edit = scanner.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (edit.equals(studentList.get(i).getId())) {
                String id = "SV-" + (studentList.size() + 1);
                System.out.print("Mời bạn nhập tên: ");
                String name = scanner.nextLine();

                LocalDate dateNow = LocalDate.now();
                boolean check;
                LocalDate dateOfBirth = null;
                do {
                    System.out.println("nhập ngay sinh theo dd/MM/yyyy");
                    String day = scanner.nextLine();
                    dateOfBirth = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period periodToNextJavaRelease = Period.between(dateOfBirth, dateNow);
                    if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
                        System.err.println("bạn đã nhập đúng ");
                        break;
                    }
                    check = false;
                    System.err.println("bạn đã nhập sai yêu cầu nhâp lại ");
                } while (!check);

                System.out.print("Mời bạn giới tính: ");
                String gender = "";
                do {
                    System.out.println("chọn giới tính " +
                            "\n 1.Nam" +
                            "\n 2.Nữ" +
                            "\n 3.LGBT");
                    System.out.println("Chọn chức năng");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            gender = "Nam";
                            break;
                        case "2":
                            gender = "Nư";
                            break;
                        case "3":
                            gender = "LGBT";
                            break;
                        default:
                            System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
                    }
                } while (gender.equals(""));
                System.out.print("Mời bạn nhập điểm: ");
                double point = Double.parseDouble(scanner.nextLine());
                System.out.print("Mời bạn nhập tên lớp: ");
                String nameClass = scanner.nextLine();

                studentList.get(i).setId(id);
                studentList.get(i).setName(name);
                studentList.get(i).setDateOfBirth(dateOfBirth);
                studentList.get(i).setGender(gender);
                studentList.get(i).setPoint(point);
                studentList.get(i).setNameClass(nameClass);

                break;
            }
        }
    }
}
