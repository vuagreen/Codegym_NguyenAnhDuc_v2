package B3_Lop_Va_Doi_Tuong.Bai_Tap;

public class fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = 1;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public fan() {
    }

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(boolean on) {
        if (on) {
            return " speed : " + speed +
                    "\n color : " + color +
                    "\n radius :" + radius +
                    "\n Fan is On ";
        } else {
            return
                    "\n color : " + color +
                            "\n radius :" + radius +
                            "\n Fan is OFF ";
        }
    }

    public static void main(String[] args) {
        fan fan1 = new fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println("Fan1 : \n" + fan1.toString(fan1.isOn()));

        fan fan2 = new fan();
        fan2.setSpeed(2);
        System.out.println("Fan2 : \n" + fan2.toString(fan2.isOn()));


    }
}
