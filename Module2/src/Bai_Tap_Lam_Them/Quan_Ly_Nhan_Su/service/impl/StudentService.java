package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.impl;


import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model.Student;
import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.IStudent;



import java.io.*;
import java.net.PortUnreachableException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StudentService implements IStudent {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Student> studentList;

    static {
        try {
            studentList = readStudentFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Student.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static final String PATH_NAME_FILE_STUDENT = "src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Student.txt";
    @Override
    public void displayAllStudent() {
        if (studentList.isEmpty()) {
            System.err.println("Chưa có dữ liệu, mời bạn nhập dữ liệu");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println((1 + i) + ". " + studentList.get(i));
            }
        }
    }
    @Override
    public void addStudent() throws IOException {
        studentList = readStudentFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Student.txt");
        Student student = this.infoStudent();
        studentList.add(student);
        System.out.println("Thêm mới học sinh thành công");
    }
    @Override
    public void removeStudent() throws IOException {
        studentList = readStudentFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Student.txt");
        Student student = this.findStudent();
        if (student == null) {
            System.err.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + student.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                studentList.remove(student);
                System.err.println("Xóa thành công!");
            }
        }
    }
    private Student findStudent() throws IOException {
        System.out.println("Mời bạn nhập vào id cần xóa: ");
        String id = scanner.nextLine();
        for (Student student : studentList) {
            if (Objects.equals(student.getId(), id)) {
                return student;
            }
        }
        return null;
    }
    public void search(){
        try {
            studentList = readStudentFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Student.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Nhập id học sinh: ");
        String id = scanner.nextLine();
        int count = 0;
        for (Student student : studentList) {
            if (id.equals(student.getId())) {
                System.out.println(student);
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Không tìm thấy học sinh");
        }
    }

    public void editStudent() throws IOException {
        studentList = readStudentFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Student.txt");
        displayAllStudent();
        System.out.println("Chọn giáo viên cần sửa ");
        String edit = scanner.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (edit.equals(studentList.get(i).getId())) {
                String id = "SV-" + (studentList.size() + 1);
                System.out.print("Mời bạn nhập tên: ");
                String name = scanner.nextLine();

                LocalDate dateNow = LocalDate.now();
                LocalDate dateOfBirth;
                do {
                    System.out.println("nhập ngay sinh theo dd/MM/yyyy");
                    String day = scanner.nextLine();
                    dateOfBirth = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period periodToNextJavaRelease = Period.between(dateOfBirth, dateNow);
                    if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
                        System.err.println("bạn đã nhập đúng ");
                        break;
                    }
                    System.err.println("bạn đã nhập sai yêu cầu nhâp lại ");
                } while (true);

                System.out.print("Mời bạn giới tính: ");
                String gender = "";
                do {
                    System.out.println("chọn giới tính " +
                            "\n 1.Nam" +
                            "\n 2.Nữ" +
                            "\n 3.LGBT");
                    System.out.println("Chọn chức năng");
                    String choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            gender = "Nam";
                            break;
                        case "2":
                            gender = "Nư";
                            break;
                        case "3":
                            gender = "LGBT";
                            break;
                        default:
                            System.err.println("yêu cầu nhập đúng số hiển thị chức năng ");
                    }
                } while (gender.equals(""));
                System.out.print("Mời bạn nhập điểm: ");
                double point = Double.parseDouble(scanner.nextLine());
                System.out.print("Mời bạn nhập tên lớp: ");
                String nameClass = scanner.nextLine();

                studentList.get(i).setId(id);
                studentList.get(i).setName(name);
                studentList.get(i).setDateOfBirth(dateOfBirth);
                studentList.get(i).setGender(gender);
                studentList.get(i).setPoint(point);
                studentList.get(i).setNameClass(nameClass);

                break;
            }
        }
    }
    public Student infoStudent() {
        String id;
        while (true) {
            try {
                id = "SV-" + (studentList.size() + 1);

                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getId() == id) {
                        throw new IOException("Id này đã tồn tại. Vui lòng nhập id khác.");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Vui lòng nhập lại.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String name;
        while (true) {
            name = scanner.nextLine();
            if (name.toLowerCase().matches("[^\\D{5,50}\\s*$]")){
                break;
            }else {
                System.out.println("mời nhập lại");
            }

        }

        String dateOfBirth;
        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày sinh theo định dạng ngày/tháng/năm:  ");
                dateOfBirth = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không đúng định dạng. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String gender="";
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính: ");
                gender = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        double point;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Integer.parseInt(scanner.nextLine());
                if (point < 0 || point > 100) {
                    throw new PortUnreachableException("Bạn không thể nhập điểm nhỏ hơn 0 và lớn hơn 100");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (PortUnreachableException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String nameClass;
        while (true) {
            nameClass = scanner.nextLine();
            if (nameClass.matches("(A|C)[\\d]{4}(G|I)[1]")){
                break;
            }else {
                System.out.println("mời nhập lại");
            }
        }
        Student student = new Student(id, name, LocalDate.parse(dateOfBirth), gender, point, nameClass);
        System.out.println(student);
        return student;
    }

    public static List<String> readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> strings = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        bufferedReader.close();
        return strings;
    }

    public static List<Student>
    readStudentFile(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Student> students = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            students.add(new Student(info[0], info[1],LocalDate.parse(info[2]),info[3],Double.parseDouble(info[4]),info[5]));
        }

        return students;
    }
    private static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writeStudentFile(String path, List<Student> students) throws IOException {
        String data = "";
        for (Student student : students) {
            data += student.toString();
            data += "\n";
        }

        writeFile(path, data);
    }
}
