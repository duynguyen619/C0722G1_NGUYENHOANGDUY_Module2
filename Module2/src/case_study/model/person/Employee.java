package Case_study_module2.model.person;

import java.time.LocalDate;

public class Employee extends Person {
    private String levelEmployee;
    private String locationEmployee;
    private String salaryEmployee;

    public Employee() {
    }

    public Employee(String levelEmployee, String locationEmployee, String salaryEmployee) {
        this.levelEmployee = levelEmployee;
        this.locationEmployee = locationEmployee;
        this.salaryEmployee = salaryEmployee;
    }

    public Employee(String id, String name, LocalDate dateOfBirth, String gender, String idNumber, String phoneNumber, String email, String levelEmployee, String locationEmployee, String salaryEmployee) {
        super(id, name, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.levelEmployee = levelEmployee;
        this.locationEmployee = locationEmployee;
        this.salaryEmployee = salaryEmployee;
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV() +","+ this.levelEmployee+","+this.locationEmployee+","+this.salaryEmployee;
    }

    public String getLevelEmployee() {
        return levelEmployee;
    }

    public void setLevelEmployee(String levelEmployee) {
        this.levelEmployee = levelEmployee;
    }

    public String getLocationEmployee() {
        return locationEmployee;
    }

    public void setLocationEmployee(String locationEmployee) {
        this.locationEmployee = locationEmployee;
    }

    public String getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(String salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString()+
                "levelEmployee='" + levelEmployee + '\'' +
                ", locationEmployee='" + locationEmployee + '\'' +
                ", salaryEmployee=" + salaryEmployee +
                '}';
    }
}
