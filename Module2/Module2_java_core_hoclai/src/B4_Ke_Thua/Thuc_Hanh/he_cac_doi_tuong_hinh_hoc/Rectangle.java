package B4_Ke_Thua.Thuc_Hanh.he_cac_doi_tuong_hinh_hoc;

public class Rectangle extends Shape {
    double width=1;
    double length=1;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return (length + width) * 2;
    }

    @Override
    public String toString() {
        return " A Rectangle With {" +
                "width=" + width +
                ", length=" + length + "which is a subclass of" +
                '}' + super.toString();
    }
}
