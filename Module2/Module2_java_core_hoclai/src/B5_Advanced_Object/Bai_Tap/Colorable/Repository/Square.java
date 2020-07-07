package B5_Advanced_Object.Bai_Tap.Colorable.Repository;

import B5_Advanced_Object.Bai_Tap.Colorable.Colorable;

public class Square extends Rectangle implements Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side,side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }
    public double getArea() {
        return getSide() * getSide();
    }

    public double getPerimeter() {
        return getSide() * 4;
    }
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public double getLength() {
        return super.getLength();
    }

    @Override
    public String toString() {
        return "A Square with {" +
                "side =" + getSide() + ", which is a subclass of " + super.toString()+
                '}';
    }

    @Override
    public void howToColor() {
        System.out.println(" Color all four sides..");
    }
}
