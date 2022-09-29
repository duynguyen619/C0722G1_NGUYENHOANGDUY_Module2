package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model;

import java.time.LocalDate;

public class Personnel {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;

    public Personnel(String id, String name, LocalDate dateOfBirth, String gender) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
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

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", id, name, dateOfBirth, gender);
    }

}
