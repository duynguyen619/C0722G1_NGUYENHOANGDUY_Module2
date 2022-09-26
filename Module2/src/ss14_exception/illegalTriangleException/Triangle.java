package ss14_exception.illegalTriangleException;

public class Triangle {
    double a, b, c;
    public Triangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Cạnh phải cao hơn 0");
        } else if (a + b < c || a + c < b || b + c < a){
            throw new IllegalTriangleException("Không phải làm tam giác");
        }else{
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ",b=" + b +
                ",c=" + c +
                "}";
    }
}
