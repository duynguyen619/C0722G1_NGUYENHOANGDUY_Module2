package Case_study_module2.service.impl;

import Case_study_module2.model.person.Employee;
import Case_study_module2.service.IEmployeeService;
import Case_study_module2.test.Check;
import Case_study_module2.util.ReadAndWriteCSV;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();
    private static final String PATH_FILE = "src/Case_study_module2/data/Employee.csv";

    @Override
    public void display() {
        List<Employee> employeeList = ReadAndWriteCSV.readEmployeeList(PATH_FILE);
        if (employeeList.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào.");
        } else {
            for (int i = 0; i < employeeList.size(); i++) {
                System.out.println((1 + i) + ". " + employeeList.get(i));
            }
        }
    }

    @Override
    public void add() {
        List<Employee> employeeList1 = ReadAndWriteCSV.readEmployeeList(PATH_FILE);
        String id = String.valueOf(employeeList1.size() + 1);
        String name = "";
        do {
            System.out.println("nhập tên");
            name = scanner.nextLine();
            if (Check.checkEmployeeName(name)) {
                System.out.println(" nhập đúng tên");
            } else {
                System.err.println(" nhập không đúng tên pháp yêu cầu nhập lại");
            }
        } while (!Check.checkEmployeeName(name));


        LocalDate dateNow = LocalDate.now();
        boolean check;
        LocalDate date = null;
        do {
            try {
                System.out.println("nhập ngay sinh theo dd/MM/yyyy");
                String day = scanner.nextLine();
                date = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Period periodToNextJavaRelease = Period.between(date, dateNow);
                if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
                    System.err.println("bạn đã nhập đúng ");
                    break;
                }
                check = false;
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            } catch (DateTimeParseException e) {
                System.err.println("bạn đã nhập sai yêu cầu nhâp lại ");
                check = false;
            }
        } while (!check);


        String gioitinh = "";
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
                    gioitinh = "Nam";
                    break;
                case "2":
                    gioitinh = "Nư";
                    break;
                case "3":
                    gioitinh = "LGBT";
                    break;
                case "4":
                    gioitinh = "Giới tính khác";
                    break;
                default:
                    System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (gioitinh.equals(""));
        String idNumber = "";
        do {
            System.out.println("nhập số CMND gồm 9 số hoặc căn cước công dân gồm 11 số");
            idNumber = scanner.nextLine();
            if (Check.checkEmployeeIdName(idNumber)) {
                System.out.println(" nhập đúng số CMND hoặc căn cước công dân");
                break;
            } else {
                System.err.println(" nhập không đúng số CMND hoặc căn cước công dân yêu cầu nhập lại");
            }
        } while (!Check.checkEmployeeIdName(idNumber));
        String idPhone = "";
        do {
            System.out.println("nhập số điện thoại ");
            idPhone = scanner.nextLine();
            if (Check.checkEmployeePhone(idPhone)) {
                System.out.println(" nhập đúng số điện thoại");
                break;
            } else {
                System.err.println(" nhập không đúng số điện thoại yêu cầu nhập lại");
            }
        } while (!Check.checkEmployeePhone(idPhone));
        String email = "";
        do {
            System.out.println("nhập số email");
            email = scanner.nextLine();
            if (Check.checkEmployeeEmail(email)) {
                System.out.println(" nhập đúng email");
                break;
            } else {
                System.err.println(" nhập không đúng email, yêu cầu nhập lại");
            }
        } while (!Check.checkEmployeeEmail(email));
        System.out.println(" nhap levelEmployee");
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
        System.out.println(" nhap locationEmployee");
        String location = "";
        do {
            System.out.println("Nhập vị trí công việc\n" +
                    "1. Lễ tân.\n" +
                    "2. Phục vụ.\n" +
                    "3. Chuyên viên.\n" +
                    "4. Giám sát.\n" +
                    "5. Quản lý.\n" +
                    "6. Giám đốc.");
            System.out.print("Mời bạn chọn: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    location = "Lễ tân";
                    break;
                case "2":
                    location = "Phục vụ";
                    break;
                case "3":
                    location = "Chuyên viên";
                    break;
                case "4":
                    location = "Giám sát";
                    break;
                case "5":
                    location = "Quản lý";
                    break;
                case "6":
                    location = "Giám đốc";
                    break;
                default:
                    System.err.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (location.equals(""));
        System.out.println(" nhap salaryEmployee");
        String salary = "";
        do {
            System.out.print("Nhập lương: ");
            salary = scanner.nextLine();
            if (Check.checkRegexSalary(salary)) {
                System.out.println(" nhập đúng số lương  ");
            } else {
                System.err.println("nhập sai số lương cần nhập lại");
            }
        } while (!Check.checkRegexSalary(salary));
        Employee employee = new Employee(id, name, date, gioitinh, idNumber, idPhone, email, level, location, salary);
        employeeList.add(employee);
        ReadAndWriteCSV.writeEmployeeListToCSV(employeeList, PATH_FILE, true);
    }

    @Override
    public void edit() {
        display();
        List<Employee> employeeList = ReadAndWriteCSV.readEmployeeList(PATH_FILE);
        System.out.println("Chọn học viên cần sửa");
        String edit = scanner.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (edit.equals(employeeList.get(i).getId())) {
                String id = String.valueOf(i + 1);
                String name = "";
                do {
                    System.out.println("nhập tên");
                    name = scanner.nextLine();
                    if (Check.checkEmployeeName(name)) {
                        System.out.println(" nhập đúng tên");
                    } else {
                        System.err.println(" nhập không đúng tên pháp yêu cầu nhập lại");
                    }
                } while (!Check.checkEmployeeName(name));

                LocalDate dateNow = LocalDate.now();
                boolean check;
                LocalDate date = null;
                do {
                    try {
                        System.out.println("nhập ngay sinh theo dd/MM/yyyy");
                        String day = scanner.nextLine();
                        date = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        Period periodToNextJavaRelease = Period.between(date, dateNow);
                        if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
                            System.out.println("bạn đã nhập đúng ");
                            break;
                        }
                        check = false;
                        System.err.println("bạn đã nhập sai yêu cầu nhâp lại ");
                    } catch (DateTimeParseException e) {
                        System.err.println("bạn đã nhập sai yêu cầu nhâp lại ");
                        check = false;
                    }
                } while (!check);

                String gioitinh = "";
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
                            gioitinh = "Nam";
                            break;
                        case "2":
                            gioitinh = "Nư";
                            break;
                        case "3":
                            gioitinh = "LGBT";
                            break;
                        case "4":
                            gioitinh = "Giới tính khác";
                            break;
                        default:
                            System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
                    }
                } while (gioitinh.equals(""));
                String idNumber = "";
                do {
                    System.out.println("nhập số CMND hoặc căn cước công dân");
                    idNumber = scanner.nextLine();
                    if (Check.checkEmployeeIdName(idNumber)) {
                        System.out.println(" nhập đúng số CMND hoặc căn cước công dân");
                        break;
                    } else {
                        System.err.println(" nhập không đúng số CMND hoặc căn cước công dân yêu cầu nhập lại");
                    }
                } while (!Check.checkEmployeeIdName(idNumber));
                String idPhone = "";
                do {
                    System.out.println("nhập số điện thoại");
                    idPhone = scanner.nextLine();
                    if (Check.checkEmployeePhone(idPhone)) {
                        System.out.println(" nhập đúng số điện thoại");
                        break;
                    } else {
                        System.err.println(" nhập không đúng số điện thoại yêu cầu nhập lại");
                    }
                } while (!Check.checkEmployeePhone(idPhone));
                String email = "";
                do {
                    System.out.println("nhập số email");
                    email = scanner.nextLine();
                    if (Check.checkEmployeeEmail(email)) {
                        System.out.println(" nhập đúng email");
                        break;
                    } else {
                        System.err.println(" nhập không đúng email, yêu cầu nhập lại");
                    }
                } while (!Check.checkEmployeeEmail(email));
                System.out.println("Cấp độ nhân viên");
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
                System.out.println("Nhập vị trí nhân viên");
                String location = "";
                do {
                    System.out.println("Nhập vị trí công việc\n" +
                            "1. Lễ tân.\n" +
                            "2. Phục vụ.\n" +
                            "3. Chuyên viên.\n" +
                            "4. Giám sát.\n" +
                            "5. Quản lý.\n" +
                            "6. Giám đốc.");
                    System.out.print("Mời bạn chọn: ");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            location = "Lễ tân";
                            break;
                        case "2":
                            location = "Phục vụ";
                            break;
                        case "3":
                            location = "Chuyên viên";
                            break;
                        case "4":
                            location = "Giám sát";
                            break;
                        case "5":
                            location = "Quản lý";
                            break;
                        case "6":
                            location = "Giám đốc";
                            break;
                        default:
                            System.err.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
                    }
                } while (location.equals(""));
                System.out.println("Nhập lương nhân viên");
                String salary = "";
                do {
                    System.out.print("Nhập lương: ");
                    salary = scanner.nextLine();
                    if (Check.checkRegexSalary(salary)) {
                        System.out.println(" nhập đúng số lương  ");
                    } else {
                        System.err.println("nhập sai số lương cần nhập lại");
                    }
                } while (!Check.checkRegexSalary(salary));
                employeeList.get(i).setId(id);
                employeeList.get(i).setName(name);
                employeeList.get(i).setDateOfBirth(date);
                employeeList.get(i).setGender(gioitinh);
                employeeList.get(i).setIdNumber(idNumber);
                employeeList.get(i).setPhoneNumber(idPhone);
                employeeList.get(i).setEmail(email);
                employeeList.get(i).setLevelEmployee(level);
                employeeList.get(i).setLocationEmployee(location);
                employeeList.get(i).setSalaryEmployee(salary);
                ReadAndWriteCSV.writeEmployeeListToCSV(employeeList, PATH_FILE, false);
                break;
            }
        }
    }

    public void delete() {
        List<Employee> employeeList = ReadAndWriteCSV.readEmployeeList(PATH_FILE);
        display();
        System.out.println("Nhập nhân viên cần xóa");
        int delete = Integer.parseInt(scanner.nextLine());
        employeeList.remove(delete - 1);
        for (int i = 0; i < employeeList.size(); i++) {
            employeeList.get(i).setId(String.valueOf(1 + i));
        }
        ReadAndWriteCSV.writeEmployeeListToCSV(employeeList, PATH_FILE, false);
    }
}
