package Giai_De.Bai1;

import java.util.Scanner;

public class TestStudent extends Candidate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Candidate candidate = new Candidate();
        int count;
        do {
            count = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < count; i++) {
                System.out.println("Nhập số thứ tự thí sinh" + (i + 1) + ":");
                candidate.setId(Integer.parseInt(scanner.nextLine()));
                System.out.println("Nhập họ vè tên");
                candidate.setName(String.valueOf(Integer.parseInt(scanner.nextLine())));
                System.out.println("Nhập ngày sinh");
                candidate.setDate(String.valueOf(Integer.parseInt(scanner.nextLine())));
                System.out.println("Nhập điểm Toán");
                candidate.setMath(Integer.parseInt(scanner.nextLine()));
                System.out.println("Nhập điểm Văn");
                candidate.setLiterature(Integer.parseInt(scanner.nextLine()));
                System.out.println("Nhập điểm Anh");
                candidate.setEnglish(Integer.parseInt(scanner.nextLine()));
            }
        } while (true);
    }
}
