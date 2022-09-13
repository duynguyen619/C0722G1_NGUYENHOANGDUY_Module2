package Giai_De.Bai1;

public class Candidate {
    private int Id;
    private String name;
    private String date;
    private double math;
    private double literature;
    private  double english;

    public Candidate() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getLiterature() {
        return literature;
    }

    public void setLiterature(double literature) {
        this.literature = literature;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", math=" + math +
                ", literature=" + literature +
                ", english=" + english +
                '}';
    }
}
