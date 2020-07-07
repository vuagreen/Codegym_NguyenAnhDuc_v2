package B4_Ke_Thua.BaiTap.ClassCircle;

public class Cylinder extends Circle {

    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.height * getRadius();
    }
    @Override
    public String toString() {
        return super.toString()
                +"This Height : "
                +getHeight()
                +"This Area :"
                +getArea();

    }
}
