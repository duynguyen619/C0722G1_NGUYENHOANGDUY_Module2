package Case_study_module2.service.impl;

import Case_study_module2.model.Booking;
import Case_study_module2.model.facility.Facility;
import Case_study_module2.model.person.Customer;
import Case_study_module2.service.IBookingService;
import Case_study_module2.util.BookingComparator;
import Case_study_module2.util.ReadAndWriteCSV;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class BookingService implements IBookingService {
    private static final String PATH_FILE_VILLA = "src/Case_study_module2/data/Villa.csv";
    private static final String PATH_FILE_HOUSE = "src/Case_study_module2/data/House.csv";
    private static final String PATH_FILE_ROOM = "src/Case_study_module2/data/Room.csv";
    private static final String PATH_FILE_CUSTOMER = "src/Case_study_module2/data/Customer.csv";
    private static final String PATH_FILE = "src/Case_study_module2/data/Booking.csv";
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        Set<Booking> bookingSet = ReadAndWriteCSV.readBookingtoCSV(PATH_FILE);
        if (bookingSet.isEmpty()) {
            System.out.println("Chưa có dữ liệu, mời bạn thêm vào.");
        } else {
            for (Booking b : bookingSet) {
                System.out.println(b);
            }
        }
    }

    @Override
    public void add() {
        Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
        Set<Booking> bookingSet1 = ReadAndWriteCSV.readBookingtoCSV(PATH_FILE);
        int id = 1;
        if (!bookingSet1.isEmpty()) {
            id = bookingSet1.size() + 1;
        }

        LocalDate dateNow = LocalDate.now();
        boolean check;
        LocalDate startDay = null;
        do {
            try {
                System.out.println("nhập bắt đầu theo dd/MM/yyyy và trong 10 năm gần đây");
                String day = scanner.nextLine();
                startDay = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Period periodToNextJavaRelease = Period.between(startDay, dateNow);
                if (periodToNextJavaRelease.getYears() < 10) {
                    System.out.println("bạn đã nhập đúng ");
                    break;
                }
                check = false;
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            } catch (DateTimeParseException e) {
                System.err.println("bạn đã nhập sai yêu cầu nhâp lại ");
                check = false;
            }
        } while (!check);
        LocalDate endDay = null;
        do {
            try {
                System.out.println("nhập kết thúc  theo dd/MM/yyyy và trong 10 năm gần đây");
                String day = scanner.nextLine();
                endDay = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Period periodToNextJavaRelease = Period.between(endDay, dateNow);
                if (periodToNextJavaRelease.getYears() < 10) {
                    System.out.println("bạn đã nhập đúng ");
                    break;
                }
                check = false;
                System.out.println("bạn đã nhập sai yêu cầu nhâp lại ");
            } catch (DateTimeParseException e) {
                System.err.println("bạn đã nhập sai yêu cầu nhâp lại ");
                check = false;
            }
        } while (!check);


        String customer = chooseCustomer();
        String facility = chooseFacility();
        Booking booking = new Booking(id, startDay, endDay, customer, facility);
        bookingSet.add(booking);
        ReadAndWriteCSV.writeBookingtoCSV(bookingSet, PATH_FILE,true);
        System.out.println("Đã booking thành công. ");
    }

    @Override
    public void edit() {

    }
    public static String chooseCustomer() {

        List<Customer> customerList = ReadAndWriteCSV.readCustomerList(PATH_FILE_CUSTOMER);
        System.out.println(" danh sách khách hàng ");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        System.out.println(" nhập id khách hàng cần chọn ");
        boolean check;
        String id = scanner.nextLine();
        do {
            check = false;
            for (Customer customer : customerList) {
                if (id.equals(customer.getId())) {
                    check = true;
                    System.out.println(customer);
                    return customer.toString();
                }
            }
            if (!check) {
                System.err.println(" bạn đã nhập sai cần nhập lại id khách hàng cần chọn ");
                id = scanner.nextLine();
            }
        } while (!check);
        return null;
    }

    public static String chooseFacility() {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        Map<Facility, Integer> facilityVilla = ReadAndWriteCSV.readListFacilityVillaToCSV(PATH_FILE_VILLA);
        Set<Facility> keySetV = facilityVilla.keySet();
        for (Facility key : keySetV) {
            facilityIntegerMap.put(key, facilityVilla.get(key));
        }
        Map<Facility, Integer> facilityHouse = ReadAndWriteCSV.readListFacilityHouseToCSV(PATH_FILE_HOUSE);
        Set<Facility> keySetH = facilityHouse.keySet();
        for (Facility key : keySetH) {
            facilityIntegerMap.put(key, facilityHouse.get(key));
        }

        Map<Facility, Integer> facilityRoom = ReadAndWriteCSV.readListFacilityRoomToCSV(PATH_FILE_ROOM);
        Set<Facility> keySetR = facilityRoom.keySet();
        for (Facility key : keySetR) {
            facilityIntegerMap.put(key, facilityRoom.get(key));
        }
        System.out.println(" danh sách dịch vụ  ");
        for (Map.Entry<Facility, Integer> f : facilityIntegerMap.entrySet()) {
            System.out.println(f.getKey().toString());
        }
        System.out.println(" nhập id dịch vụ cần chọn ");
        boolean check = true;

        String id = scanner.nextLine();
        while (check) {
            for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
                if (id.equals(entry.getKey().getIdService())) {
                    check = false;
                    return entry.getKey().toString();
                }
            }
            if (check) {
                System.err.println(" bạn đã nhập sai cần nhập lại id dịch vụ cần chọn ");
                id = scanner.nextLine();
            }
        }
        return null;
    }
}
