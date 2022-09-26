package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.controller;

import java.io.IOException;
import java.util.Scanner;

public class PersonnelController  {
    public void menuManagement()throws IOException {
            Scanner scanner = new Scanner(System.in);
            TeacherController teacherController = new TeacherController();
            StudentController studentController = new StudentController();
            while (true) {
                System.out.println("---------------------------------------------");
                System.out.println("Chào mừng bạn đến với hệ thống quản lí của codegym ĐN");
                System.out.println("1. Quản lí giảng viên");
                System.out.println("2. Quản lí học viên");
                System.out.print("Mời bạn nhập chức năng: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        teacherController.managementTeacher();
                        break;
                    case 2:
                        studentController.managementStudent();
                        break;
                    default:
                        System.out.println("Lựa chọn bạn nhập không đúng!");
                }
            }
        }
    }