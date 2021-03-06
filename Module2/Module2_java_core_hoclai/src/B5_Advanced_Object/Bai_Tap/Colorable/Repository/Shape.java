package B5_Advanced_Object.Bai_Tap.Colorable.Repository;

public class Shape {
    private String color="green";
    private boolean filled=true;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Shape() {

    }  public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    @Override
    public String toString() {
        String stt;
        if (isFilled()) {
            stt = "filled";

        } else {
            stt = "not Filled";
        }
        return "A Shape with {" +
                "color='" + color + '\'' +
                ", filled=" + stt +
                '}';
    }
}
