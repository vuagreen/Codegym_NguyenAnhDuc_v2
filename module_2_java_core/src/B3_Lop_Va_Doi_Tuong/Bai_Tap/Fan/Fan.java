package B3_Lop_Va_Doi_Tuong.Bai_Tap.Fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = 1;
    private boolean on = false;
    private String color = "Blue";

    public Fan() {
    }

    public Fan(int speed, boolean on, String color) {
        this.speed = speed;
        this.on = on;
        this.color = color;
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

    public boolean getOn() {
        return on;

    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String check() {
        if (this.getOn()) {
            return "On";
        } else {
            return "OFF";
        }

    }

    public void toString1() {
        System.out.println("Speed :" + getSpeed() + " \t Color : " + getColor() + "\t Fan is " + check());
    }

}
