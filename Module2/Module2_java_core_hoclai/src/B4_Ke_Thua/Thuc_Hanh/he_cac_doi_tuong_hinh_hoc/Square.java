package B4_Ke_Thua.Thuc_Hanh.he_cac_doi_tuong_hinh_hoc;

public class Square extends Rectangle {
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
}
