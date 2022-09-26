package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.impl;

import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model.Teacher;
import Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.service.ITeacher;
import sun.awt.HKSCS;

import javax.naming.Name;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TeacherService implements ITeacher {


    private static final Scanner scanner = new Scanner(System.in);
    private static  List<Teacher> teacherList;

    static {
        try {
            teacherList = readTeacherFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Teacher.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static final String PATH_NAME_FILE_TEACHER = "src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Teacher.txt";

    public void displayAllTeacher() throws IOException {
        teacherList = readTeacherFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Teacher.txt");
        if (teacherList.isEmpty()) {
            System.err.println("Chưa có dữ liệu, mời bạn nhập dữ liệu");
        } else {
            for (int i = 0; i < teacherList.size(); i++) {
                System.out.println((1 + i) + ". " + teacherList.get(i));
            }
        }
    }

    public void addTeacher() throws IOException {
        teacherList = readTeacherFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Teacher.txt");
        Teacher teacher = this.infoTeacher();
        teacherList.add(teacher);
        boolean swap = true;
        for (int k = 0; k < teacherList.size() - 1 && swap; k++) {
            swap = false;
            for (int i = 0; i < teacherList.size() - 1 - k; i++) {
                if (teacherList.get(i).getId().compareTo(teacherList.get(i + 1).getId()) > 0) {
                    swap = true;
                    Teacher temp = teacherList.get(i + 1);
                    teacherList.set(i + 1, teacherList.get(i));
                    teacherList.set(i, temp);
                }
            }
        }
        System.out.println("Thêm mới học sinh thành công");
    }


    public void removeTeacher() throws IOException {
        teacherList = readTeacherFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Teacher.txt");
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.err.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có chắc muốn xóa đối tượng có id là " + teacher.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teacherList.remove(teacher);
                System.err.println("Xóa thành công!");
            }
        }
    }

    private Teacher findTeacher() throws IOException {
        teacherList = readTeacherFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Teacher.txt");
        System.out.println("Mời bạn nhập vào id cần xóa: ");
        String id = scanner.nextLine();
        for (Teacher teacher : teacherList) {
            if (Objects.equals(teacher.getId(), id)) {
                return teacher;
            }
        }
        return null;
    }

    public Teacher infoTeacher() {
        String id;
        while (true) {
            try {
                id = "GV-" + (teacherList.size() + 1);

                for (int i = 0; i < teacherList.size(); i++) {
                    if (teacherList.get(i).getId() == id) {
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
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String dateOfBirth;
        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày sinh theo định dạng ngày/tháng/năm:  ");
                dateOfBirth = scanner.nextLine();
                break;
            } catch (IllegalAccessError e) {
                System.out.println("Bạn nhập không đúng định dạng. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String gender;
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

        String specialize;
        while (true) {
            try {
                System.out.print("Mời bạn nhập chuyên môn: ");
                specialize = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }
        Teacher teacher = new Teacher(id, name, LocalDate.parse(dateOfBirth), gender, specialize);
        System.out.println(teacher);
        return teacher;
    }

    public void search() {
        System.out.print("Nhập tên giáo viên: ");
        String name = scanner.nextLine();
        int count = 0;
        for (Teacher teacher : teacherList) {
            if (name.contains(teacher.getName())) {
                System.out.println(teacher);
                count++;
            }
            if (count == 0) {
                System.out.println("Nhập id giáo viên: ");
                String id = scanner.nextLine();
                if (id.equals(teacher.getId())) {
                    System.err.println(teacher);
                    count++;
                }
            }
        }
    }

    public void editTeacher() throws IOException {
        teacherList = readTeacherFile("src/Bai_Tap_Lam_Them/Quan_Ly_Nhan_Su/data/Teacher.txt");
        displayAllTeacher();
        System.out.println("Chọn sinh viên cần sửa:");
        String edit = scanner.nextLine();
        for (int i = 0; i < teacherList.size(); i++) {
            if (edit.equals(teacherList.get(i).getId())) {
                String id = "GV-" + (teacherList.size() + 1);
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
                            "\n 3.LGBT" +
                            "\n 4.Giới tính khác");
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
                System.out.print("Mời bạn trình độ: ");
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

                teacherList.get(i).setId(id);
                teacherList.get(i).setName(name);
                teacherList.get(i).setDateOfBirth(dateOfBirth);
                teacherList.get(i).setGender(gender);
                teacherList.get(i).setLevel(level);

                break;
            }
        }
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

    public static List<Teacher> readTeacherFile(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Teacher> teachers = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            teacherList.add(new Teacher(info[0], info[1], LocalDate.parse(info[2]),info[3],info[4]));
        }

        return teachers;
    }
    private static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writeTeachertFile(String path, List<Teacher> teachers) throws IOException {
        String data = "";
        for (Teacher teacher : teachers) {
            data += teacher.toString();
            data += "\n";
        }

        writeFile(path, data);
    }
}
