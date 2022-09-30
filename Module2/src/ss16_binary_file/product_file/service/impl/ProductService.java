package ss16_binary_file.product_file.service.impl;


import ss16_binary_file.product_file.model.Product;
import ss16_binary_file.product_file.service.IProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProduct {
    private static Scanner scanner = new Scanner(System.in);
    public void addProduct(){
        System.out.println("Nhập Id: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tên nhà sản xuất: ");
        String producer = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price=Double.parseDouble(scanner.nextLine());

        List<Product> products = readFile();
        products.add(new Product(id, name,producer, price));

        File file = new File("src/ss16_binary_file/product_file/data/Product.csv");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                assert fileOutputStream != null;
                fileOutputStream.close();
                assert objectOutputStream != null;
                objectOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public List<Product> readFile(){
        List<Product> products = new ArrayList<>();

        File file = new File("src/ss16_binary_file/product_file/data/Product.csv");
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            if (file.length()>0){
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                products = (List<Product>) objectInputStream.readObject();
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (file.length()>0){
                    fileInputStream.close();
                    objectInputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return products;
    }

    public void displayProduct(){
        List<Product> products = readFile();
        System.out.println("Danh sách sản phẩm: ");
        for (Product product: products){
            System.out.println(product);
        }
    }

    public void search(){
        List<Product> products = readFile();
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        for (int i = 0; i < products.size(); i++) {
            if (name.equals(products.get(i).getName())){
                System.out.println(products.get(i));
                return;
            }
        }
        System.out.println("Không thể tìm kiếm sản phẩm!");
    }
}
