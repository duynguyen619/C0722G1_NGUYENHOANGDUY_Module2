package Bai_Tap_Lam_Them.Quan_Ly_Nhan_Su.model;


public class Teacher extends Personnel {
    private String specialize;

    public Teacher(int id, String name, String dateOfBirth, String gender, String specialize) {
        super(id, name, dateOfBirth, gender);
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "specialize='" + specialize + '\'' +
                "} " + super.toString();
    }
}
