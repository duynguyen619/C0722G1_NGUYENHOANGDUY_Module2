package case_study.controller;



import java.util.Scanner;

public class ControllerFurama {
    public static void displayMainMenu() {
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Quản lý nhân sự" +
                    "\n 2.Quản lý khách hàng" +
                    "\n 3.Quản lý cơ sở " +
                    "\n 4.Quản lý đặt phòng" +
                    "\n 5.Quản lý khuyến mãi" +
                    "\n 6. Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng quản lý nhân sự");
                    employeeManagementMenu();
                    break;
                case "2":
                    System.out.println("Chức năng quản lý khách hàng");
                    customerManagementMenu();
                    break;
                case "3":
                    System.out.println("Chức năng quản lý cơ sở vật chất");
                    facilityManagementMenu();
                    break;
                case "4":
                    System.out.println("chức năng quản lý đặt phòng");
                    bookingManagementMenu();
                    break;
                case "5":
                    System.out.println("chức năng quản lý khuyến mãi");
                    promotionManagementMenu();
                    break;
                case "6":
                    return;
                default:
                    System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (true);

    }

    private static void employeeManagementMenu() {
        IEmployeeService employeeServices = null;
        do {
            employeeServices = new EmployeeService();
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Hiển thị danh sách nhân sự" +
                    "\n 2.Thêm mới nhân sự" +
                    "\n 3.Chỉnh sửa nhân sự" +
                    "\n 4.Xóa nhân sự" +
                    "\n 5.Về lại menu chính");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Hiển thị danh sách nhân sự");
                    employeeServices.display();
                    break;
                case "2":
                    System.out.println("Chức năng Thêm mới nhân sự");
                    employeeServices.add();
                    break;
                case "3":
                    System.out.println("Chức năng Chỉnh sửa nhân sự");
                    employeeServices.edit();
                    break;
                case "4":
                    System.out.println("Chức năng Xóa nhân sự");
                    // sửa sau
                    EmployeeService employeeService = new EmployeeService();
                    employeeService.delete();
                    break;
                case "5":
                    System.out.println("chức năng về lại menu chính");
                    return;
                default:
                    System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (true);
    }

    private static void customerManagementMenu() {
        CustomerService customerService = null;
        do {
            customerService = new CustomerService();
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Hiển thị danh sách khách hàng" +
                    "\n 2.Thêm mới khách hàng" +
                    "\n 3.Sửa Khách hàng" +
                    "\n 4.Xóa khách hàng" +
                    "\n 5.Về lại menu chính");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Hiển thị danh sách khách hàng");
                    customerService.display();
                    break;
                case "2":
                    System.out.println("Chức năng Thêm mới khách hàng");
                    customerService.add();
                    break;
                case "3":
                    System.out.println("Chức năng Sửa Khách hàng");
                    customerService.edit();
                    break;
                case "4":
                    System.out.println("Chức năng Xóa khách hàng");
                    CustomerService customerService1 = new CustomerService();
                    customerService1.delete();
                    break;
                case "5":
                    System.out.println("chức năng về lại menu chính");
                    return;
                default:
                    System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (true);
    }

    private static void facilityManagementMenu() {
        FacilityService facilityService = null;
        do {
            facilityService = new FacilityService();
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Danh sách hiển thị cơ sở" +
                    "\n 2.Thêm cơ sở mới" +
                    "\n 3.Chỉnh sửa cơ sở" +
                    "\n 4.Về lại menu chính");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Danh sách hiển thị cơ sở");
                    facilityService.display();
                    break;
                case "2":
                    System.out.println("Chức năng Thêm cơ sở mới");
                    facilityService.add();
                    break;
                case "3":
                    System.out.println("Chức năng Chỉnh sửa cơ sở");

                    break;
                case "4":
                    System.out.println("chức năng Về lại menu chính");
                    return;
                default:
                    System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (true);
    }

    private static void bookingManagementMenu() {
        BookingService bookingService = null;
        do {
            bookingService = new BookingService();
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Thêm đặt phòng mới" +
                    "\n 2.Hiển thị danh sách đặt phòng" +
                    "\n 3.Tạo hợp đồng mới" +
                    "\n 4.Hiển thị Hợp đồng danh sách" +
                    "\n 5.Chỉnh sửa hợp đồng" +
                    "\n 6.Trả về menu chính");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Thêm đặt phòng mới");
                    bookingService.add();
                    break;
                case "2":
                    System.out.println("Chức năng Hiển thị danh sách đặt phòng");
                    bookingService.display();
                    break;
                case "3":
                    System.out.println("Chức năng Tạo hợp đồng mới");

                    break;
                case "4":
                    System.out.println("Chức năng Hiển thị Hợp đồng danh sách");

                    break;
                case "5":
                    System.out.println("Chức năng Chỉnh sửa hợp đồng");

                    break;
                case "6":
                    System.out.println("Chức năng Trả về menu chính");
                    return;
                default:
                    System.err.println("Yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (true);
    }

    private static void promotionManagementMenu() {
        boolean flag = true;
        do {
            System.out.println("Chức năng của hệ thống " +
                    "\n 1.Hiển thị danh sách khách hàng sử dụng dịch vụ" +
                    "\n 2.Danh sách hiển thị khách hàng nhận được chứng từ" +
                    "\n 3.Trả về menu chính");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chọn chức năng");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("chức năng Hiển thị danh sách khách hàng sử dụng dịch vụ");

                    break;
                case "2":
                    System.out.println("Chức năng Danh sách hiển thị khách hàng nhận được chứng từ");

                    break;
                case "3":
                    System.out.println("chức năng Trả về menu chính");
                    return;
                default:
                    System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
            }
        } while (true);
    }
}
