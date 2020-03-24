package B4_Ke_Thua.BaiTap.ClassCircle;

public class Circle {
    private double radius ;
    private String color;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getAcreage() {
        return this.radius * this.radius * Math.PI;
    }
    @Override
    public String toString() {
        return "This color : "
                + getColor()
                +"This Radius :"
                +getRadius()
                +"This Acreage : "
                +getAcreage();
    }
}
