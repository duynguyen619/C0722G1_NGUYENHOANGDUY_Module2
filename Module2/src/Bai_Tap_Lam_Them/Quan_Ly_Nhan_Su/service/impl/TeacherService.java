package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.impl;

import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model.Teacher;
import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.ITeacher;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacher {


    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Teacher> teacherList = new ArrayList<>();


//    static {
//        teacherList.add(new Teacher(2, "Lương Thị Thanh Thủy", "22/12/1999", "Nữ", "Đại học"));
//        teacherList.add(new Teacher(3, "Nguyễn Hoàng Duy", "06/062001", "Nam", "Cao đẳng"));
//        teacherList.add(new Teacher(1, "Hoàng Vân Anh", "13/13/1313", "Nam", "Trung cấp"));
//    }

    public void sortTeacher() {
        for (int i = 1; i < teacherList.size(); i++) {
            Teacher temp1 = teacherList.get(i);
            int j;
            for (j = i - 1; j >= 0 && teacherList.get(j).getName().compareTo(temp1.getName()) < 0; j--) {
                teacherList.set(j + 1, teacherList.get(j));
            }
            teacherList.set(j + 1, temp1);
        }
        System.out.println("Đã sắp xếp!");
    }

    public void displayAllTeacher() {
        if (teacherList.isEmpty()) {
            System.err.println("Chưa có dữ liệu, mời bạn nhập dữ liệu");
        } else {
            for (int i = 0; i < teacherList.size(); i++) {
                System.out.println((1 + i) + ". " + teacherList.get(i));
            }
        }
    }

    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm mới học sinh thành công");
    }


    public void removeTeacher() {
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.err.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + teacher.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teacherList.remove(teacher);
                System.err.println("Xóa thành công!");
            }
        }
    }

    private Teacher findTeacher() {
        System.out.println("Mời bạn nhập vào id cần xóa: ");
        String id = scanner.nextLine();
        for (Teacher teacher : teacherList) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public Teacher infoTeacher() {
        String id = "GV-" + (teacherList.size() + 1);
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
                    "\n 3.LGBT" +
                    "\n 4.Giới tính khác");
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
                case "4":
                    gender = "Giới tính khác";
                    break;
                default:
                    System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (gender.equals(""));
        System.out.print("Mời bạn trình độ: ");
        String level = "";
        String choose;
        do {
            System.out.println("Nhập trình độ\n" +
                    "1. Trung cấp.\n" +
                    "2. Cao đẳng.\n" +
                    "3. Đại học.\n" +
                    "4. Sau đại học.");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    level = "Trung cấp";
                    break;
                case "2":
                    level = "Cao đẳng";
                    break;
                case "3":
                    level = "Đại học";
                    break;
                case "4":
                    level = "Sau đại học";
                    break;
                default:
                    System.err.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (level.equals(""));
        return new Teacher(id, name, dateOfBirth, gender, level);
    }

    public void search() {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        int count = 0;
        for (Teacher teacher : teacherList) {
            if (name.contains(teacher.getName())) {
                System.out.println(teacher);
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Không có tên giáo viên");
        }
    }

    public void editTeacher() {
        displayAllTeacher();
        System.out.println("Chọn khách hàng cần sửa ");
        String edit = scanner.nextLine();
        for (int i = 0; i < teacherList.size(); i++) {
            if (edit.equals(teacherList.get(i).getId())) {
                String id = "GV-" + (teacherList.size() + 1);
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
                            "\n 3.LGBT" +
                            "\n 4.Giới tính khác");
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
                        case "4":
                            gender = "Giới tính khác";
                            break;
                        default:
                            System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
                    }
                } while (gender.equals(""));
                System.out.print("Mời bạn trình độ: ");
                String level = "";
                String choose;
                do {
                    System.out.println("Nhập trình độ\n" +
                            "1. Trung cấp.\n" +
                            "2. Cao đẳng.\n" +
                            "3. Đại học.\n" +
                            "4. Sau đại học.");
                    System.out.print("Mời bạn chọn: ");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            level = "Trung cấp";
                            break;
                        case "2":
                            level = "Cao đẳng";
                            break;
                        case "3":
                            level = "Đại học";
                            break;
                        case "4":
                            level = "Sau đại học";
                            break;
                        default:
                            System.err.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
                    }
                } while (level.equals(""));

                teacherList.get(i).setId(id);
                teacherList.get(i).setName(name);
                teacherList.get(i).setDateOfBirth(dateOfBirth);
                teacherList.get(i).setGender(gender);
                teacherList.get(i).setLevel(level);

                break;
            }
        }
    }
}
