package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.controller;

import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.impl.StudentService;


import java.io.IOException;
import java.util.Scanner;

public class StudentController {
    Scanner scanner = new Scanner(System.in);
    StudentService iStudentService = new StudentService() {
    };


    public void managementStudent() throws IOException {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với hệ thống quản lí học viên");
            System.out.println("1. Hiển thị danh sách học viên");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Cập nhật thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Tìm học sinh");
            System.out.println("6. Exit");
            System.out.print("Mời bạn nhập chức năng 1->5: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iStudentService.displayAllStudent();
                    break;
                case 2:
                    iStudentService.addStudent();
                    break;
                case 3:
                    iStudentService.editStudent();
                    break;
                case 4:
                    iStudentService.removeStudent();
                    break;
                case 5:
                    iStudentService.search();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
