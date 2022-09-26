package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.controller;

import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.impl.TeacherService;

import java.io.IOException;
import java.util.Scanner;

public class TeacherController {
    Scanner scanner = new Scanner(System.in);
    TeacherService iTeacherService = new TeacherService() {
    };


    public void managementTeacher() throws IOException {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với hệ thống quản lí giáo viên");
            System.out.println("1. Hiển thị danh sách giáo viên");
            System.out.println("2. Thêm mới giáo viên");
            System.out.println("3. Cập nhật thông tin giáo viên");
            System.out.println("4. Xóa giáo viên");
            System.out.println("5. Tìm giáo viên");
            System.out.println("7. Exit");
            System.out.print("Mời bạn nhập chức năng 1->5: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iTeacherService.displayAllTeacher();
                    break;
                case 2:
                    iTeacherService.addTeacher();
                    break;
                case 3:
                    iTeacherService.editTeacher();
                    break;
                case 4:
                    iTeacherService.removeTeacher();
                    break;
                case 5:
                    iTeacherService.search();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }
        }
    }
}
