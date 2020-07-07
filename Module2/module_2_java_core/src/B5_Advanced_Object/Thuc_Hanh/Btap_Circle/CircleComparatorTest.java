package B5_Advanced_Object.Thuc_Hanh.Btap_Circle;

import B4_Ke_Thua.Thuc_Hanh.Doi_Tuong_Hinh_Hoc.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);
        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
