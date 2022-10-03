package Case_study_module2.util;

import Case_study_module2.model.Booking;
import Case_study_module2.model.facility.Facility;
import Case_study_module2.model.facility.House;
import Case_study_module2.model.facility.Room;
import Case_study_module2.model.facility.Villa;
import Case_study_module2.model.person.Customer;
import Case_study_module2.model.person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ReadAndWriteCSV {
    private static List<String> readObjectToCSV(String pathFile) {
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }
    private static void writeObjectToCSV(List<String> strings, String pathFile, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < strings.size(); i++) {
                bufferedWriter.write(strings.get(i));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeEmployeeListToCSV(List<Employee> employeeList, String pathFile, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            stringList.add(employeeList.get(i).getInfoToCSV());
        }
        writeObjectToCSV(stringList, pathFile, append);
    }
    public static List<Employee> readEmployeeList(String pathFile) {
        List<Employee> employeeList = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            employeeList.add(new Employee(array[0], array[1], LocalDate.parse(array[2]), array[3], array[4], array[5], array[6], array[7], array[8], array[9]));
        }
        return employeeList;
    }
    public static void writeCustomerListToCSV(List<Customer> customerList, String pathFile, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            stringList.add(customerList.get(i).getInfoToCSV());
        }
        writeObjectToCSV(stringList, pathFile, append);
    }

    public static List<Customer> readCustomerList(String pathFile) {
        List<Customer> customerList = new ArrayList<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            customerList.add(new Customer(array[0], array[1], LocalDate.parse(array[2]), array[3], array[4], array[5], array[6], array[7], array[8]));
        }
        return customerList;
    }

    public static void writeListFacilityToCSV(Map<Facility, Integer> facilityIntegerMap, String pathFile, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility key : facilitySet) {
            stringList.add(key.getInfoToCSV() + "," + facilityIntegerMap.get(key));
        }
        writeObjectToCSV(stringList, pathFile, append);
    }

    public static Map<Facility, Integer> readListFacilityVillaToCSV(String pathFile) {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            facilityIntegerMap.put(new Villa(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6], Double.parseDouble(array[7]), Integer.parseInt(array[8])), Integer.parseInt(array[9]));
        }
        return facilityIntegerMap;
    }

    public static Map<Facility, Integer> readListFacilityRoomToCSV(String pathFile) {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            facilityIntegerMap.put(new Room(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6]), Integer.parseInt(array[7]));
        }
        return facilityIntegerMap;
    }

    public static Map<Facility, Integer> readListFacilityHouseToCSV(String pathFile) {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            facilityIntegerMap.put(new House(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6], Integer.parseInt(array[7])), Integer.parseInt(array[8]));
        }
        return facilityIntegerMap;
    }

    public static void writeBookingtoCSV(Set<Booking> bookingSet, String pathFile, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Booking b : bookingSet) {
            stringList.add(b.getInfoToCSV());
        }
        writeObjectToCSV(stringList, pathFile, append);
    }

    public static Set<Booking> readBookingtoCSV(String pathFile) {
        Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
        List<String> strings = readObjectToCSV(pathFile);
        String[] array;
        for (int i = 0; i < strings.size(); i++) {
            array = strings.get(i).split(",");
            bookingSet.add(new Booking(Integer.parseInt(array[0]), LocalDate.parse(array[1]), LocalDate.parse(array[2]), array[3], array[4]));
        }
        return bookingSet;
    }
}
