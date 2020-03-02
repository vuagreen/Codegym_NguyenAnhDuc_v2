package B3_Lop_Va_Doi_Tuong.Bai_Tap.Fan;

public class Control extends Fan {
    public Control() {
    }

    public Control(int speed, boolean on, String color) {
        super(speed, on, color);
    }

    public static void main(String[] args) {
        Control control = new Control(2, true, "Red");
        control.toString1();

    }
}
