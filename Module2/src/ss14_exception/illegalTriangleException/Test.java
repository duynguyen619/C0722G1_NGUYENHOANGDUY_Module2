package ss14_exception.illegalTriangleException;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập 3 cạnh của tam giác");
        Triangle triangle;
        do {
            try {
                double a = Double.parseDouble(scanner.nextLine());
                double b = Double.parseDouble(scanner.nextLine());
                double c = Double.parseDouble(scanner.nextLine());
                triangle = new Triangle(a, b, c);
                break;
            } catch (IllegalTriangleException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Không phải văn bản");
            }
        }while (true);
        System.out.println(triangle);
    }
}
