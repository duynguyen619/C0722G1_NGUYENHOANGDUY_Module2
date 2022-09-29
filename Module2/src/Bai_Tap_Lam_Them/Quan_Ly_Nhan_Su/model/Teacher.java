package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model;


import java.time.LocalDate;

public class Teacher extends Personnel {
    private String level;

    public Teacher(String id, String name, LocalDate dateOfBirth, String gender, String specialize) {
        super(id, name, dateOfBirth, gender);
        this.level = specialize;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {return String.format("%s", super.toString(),level);}

}
