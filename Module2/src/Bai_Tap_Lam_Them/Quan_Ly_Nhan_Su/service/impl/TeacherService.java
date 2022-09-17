package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.impl;

import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model.Teacher;
import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.ITeacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacher {


    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Teacher> teacherList = new ArrayList<>() ;


    static {
        teacherList.add(new Teacher(123, "Lương Thị Thanh Thủy", "22/12/1999", "Nữ", "Quá giỏi"));
        teacherList.add(new Teacher(456, "Nguyễn Hoàng Duy", "06/062001", "Nam", "Biết bình thường"));
        teacherList.add(new Teacher(789, "Hoàng Vân Anh", "13/13/1313", "Nam", "Tạm chấp nhận"));
    }

    public void sortTeacher() {
        for (int i = 1; i < teacherList.size(); i++) {
            Teacher temp1 = teacherList.get(i);
            int j;
            for (j = i - 1; j >= 0 && teacherList.get(j).getName().compareTo(temp1.getName()) > 0; j--) {
                teacherList.set(j + 1, teacherList.get(j));
            }
            teacherList.set(j + 1, temp1);
        }
        System.out.println("Đã sắp xếp!");
    }

    public void displayAllTeacher() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    public void addTeacher(){
        Teacher teacher = this.infoTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm mới học sinh thành công");
    }


    public void removeTeacher(){
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + teacher.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teacherList.remove(teacher);
                System.out.println("Xóa thành công!");
            }
        }
    }

    private Teacher findTeacher() {
        System.out.println("Mời bạn nhập vào id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Teacher teacher : teacherList) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public Teacher infoTeacher() {
        System.out.print("Mời bạn nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        String specialize = scanner.nextLine();
        return new Teacher(id,name,dateOfBirth,gender,specialize);
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
            System.out.println("Không có tên giáo viên");
        }
    }
}
