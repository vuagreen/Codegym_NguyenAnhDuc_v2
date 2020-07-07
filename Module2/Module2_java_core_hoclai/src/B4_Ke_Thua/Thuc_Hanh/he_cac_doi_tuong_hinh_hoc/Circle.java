package B4_Ke_Thua.Thuc_Hanh.he_cac_doi_tuong_hinh_hoc;

public class Circle extends Shape{
    private double radius=1;

    public Circle(double radius,String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius *radius* Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="+radius+", which is a subclass of "+super.toString();
    }
}
