package B5_Advanced_Object.Thuc_Hanh.Btap_Circle;

import B4_Ke_Thua.Thuc_Hanh.Doi_Tuong_Hinh_Hoc.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1,Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
