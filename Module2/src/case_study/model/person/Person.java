package Case_study_module2.model.person;

import java.time.LocalDate;

public class Person {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String idNumber;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String id, String name, LocalDate dateOfBirth, String gender, String idNumber, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfoToCSV() {
        return this.id + "," + this.name + "," + this.dateOfBirth + "," + this.gender + "," + this.idNumber + "," + this.phoneNumber + "," + this.email;
    }



    @Override
    public String toString() {
        return "id='" + id + '\'' +
                "; name='" + name + '\'' +
                "; dateOfBirth=" + dateOfBirth +
                "; gender='" + gender + '\'' +
                "; idNumber=" + idNumber +
                "; phoneNumber=" + phoneNumber +
                "; email='" + email + '\'';
    }
    
}
