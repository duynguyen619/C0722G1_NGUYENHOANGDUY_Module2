package ss11_map_tree.product_management.controller;



import ss11_map_tree.product_management.service.IProduct;
import ss11_map_tree.product_management.service.impl.ProductService;

import java.util.Scanner;

public class MainController {
    private static final Scanner scanner = new Scanner(System.in);
    private final IProduct product = new ProductService();


    public void menuMangement() {
        while (true) {
            System.err.println("-----------------------------------------------------");
            System.err.println("Chào mừng bạn đến với siêu thị của chúng tôi");
            System.out.println("1.Hiển thị danh sách sản phẩm");
            System.out.println("2.Thêm mới sản phẩm");
            System.out.println("3.Cập nhật thông tin sản phẩm");
            System.out.println("4.Tìm kiếm sản phẩm bằng tên");
            System.out.println("5. Xóa sản phẩm");
            System.out.println("6. Sắp xếp");
            System.out.println("7.Exit");
            System.out.println("mời bạn nhập chức năng từ 1->6");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    product.displayProduct();
                    break;
                case 2:
                    product.addProduct();
                    break;
                case 3:
                    product.editProduct();
                    break;
                case 4:
                    product.search();
                    break;
                case 5:
                    product.removeProduct();
                    break;
                case 6:
                    break;
                case 7:
                    return;
                default:
                    System.out.println("lựa chọn của bạn không đúng!");
            }
        }
    }
}
