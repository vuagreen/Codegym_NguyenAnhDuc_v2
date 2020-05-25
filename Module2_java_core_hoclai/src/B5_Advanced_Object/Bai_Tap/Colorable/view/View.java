package B5_Advanced_Object.Bai_Tap.Colorable.view;

import B5_Advanced_Object.Bai_Tap.Colorable.Repository.Circle;
import B5_Advanced_Object.Bai_Tap.Colorable.Repository.Rectangle;
import B5_Advanced_Object.Bai_Tap.Colorable.Repository.Shape;
import B5_Advanced_Object.Bai_Tap.Colorable.Repository.Square;

public class View {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle();
        shapes[1] = new Circle(3.7, "red", false);
        shapes[4] = new Rectangle();
        shapes[3] = new Rectangle("green", true, 3, 3);
        shapes[2] = new Square("black", true, 5);
        for (Shape shape : shapes) {
            System.out.println("This area :");
            System.out.println(shape.getArea());
            if (shape instanceof Square) {
                Square square = (Square) shape;
                square.howToColor();
            }
        }
    }
}
