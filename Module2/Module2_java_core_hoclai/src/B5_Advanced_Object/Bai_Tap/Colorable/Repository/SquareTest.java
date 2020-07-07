package B5_Advanced_Object.Bai_Tap.Colorable.Repository;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square( "yellow", true,5.8);
        System.out.println(square);
    }
}
