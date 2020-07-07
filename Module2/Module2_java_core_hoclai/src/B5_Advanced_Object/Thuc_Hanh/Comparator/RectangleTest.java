package B5_Advanced_Object.Thuc_Hanh.Comparator;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle("Blue", true, 2.5, 3.5);
        System.out.println(rectangle);
    }
}
