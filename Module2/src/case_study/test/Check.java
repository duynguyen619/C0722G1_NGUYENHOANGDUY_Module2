package Case_study_module2.test;

import Case_study_module2.model.person.Customer;
import Case_study_module2.model.person.Employee;
import Case_study_module2.util.ReadAndWriteCSV;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    private static final String PATH_FILE_EMPLOYEE = "src/Case_study_module2/data/Employee.csv";
    private static final String PATH_FILE_CUSTOMER = "src/Case_study_module2/data/Customer.csv";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String PHONE_REGEX = "^(84|0[3|5|7|8|9])+([0-9]{8})$";
    private static final String IDNAME_REGEX = "^\\d{9}||\\d{12}$";
    private static final String SAlARY_REGEX = "^\\d+$";
    private static final String NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$";
    private static final String NAME_FACILITY_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$";
    private static final List<Employee> employeeList = ReadAndWriteCSV.readEmployeeList(PATH_FILE_EMPLOYEE);
    private static final List<Customer> customerList = ReadAndWriteCSV.readCustomerList(PATH_FILE_CUSTOMER);


    public static Boolean checkEmployeeEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < employeeList.size(); i++) {
                if (email.equals(employeeList.get(i).getEmail())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkEmployeePhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < employeeList.size(); i++) {
                if (phone.equals(employeeList.get(i).getPhoneNumber())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkEmployeeIdName(String idname) {
        Pattern pattern = Pattern.compile(IDNAME_REGEX);
        Matcher matcher = pattern.matcher(idname);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < employeeList.size(); i++) {
                if (idname.equals(employeeList.get(i).getIdNumber())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkEmployeeName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < employeeList.size(); i++) {
                if (name.equals(employeeList.get(i).getName())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkRegexSalary(String name) {
        Pattern pattern = Pattern.compile(SAlARY_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static Boolean checkCustomerEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < customerList.size(); i++) {
                if (email.equals(customerList.get(i).getEmail())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkCustomerPhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < customerList.size(); i++) {
                if (phone.equals(customerList.get(i).getPhoneNumber())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkCustomerIdName(String idname) {
        Pattern pattern = Pattern.compile(IDNAME_REGEX);
        Matcher matcher = pattern.matcher(idname);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < customerList.size(); i++) {
                if (idname.equals(customerList.get(i).getIdNumber())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static Boolean checkCustomerName(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean check = false;
        if (matcher.matches()) {
            check = true;
            for (int i = 0; i < customerList.size(); i++) {
                if (name.equals(customerList.get(i).getName())) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

}
