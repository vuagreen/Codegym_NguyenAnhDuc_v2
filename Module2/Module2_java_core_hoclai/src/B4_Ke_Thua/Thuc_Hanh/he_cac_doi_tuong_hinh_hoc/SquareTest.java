package B4_Ke_Thua.Thuc_Hanh.he_cac_doi_tuong_hinh_hoc;

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
