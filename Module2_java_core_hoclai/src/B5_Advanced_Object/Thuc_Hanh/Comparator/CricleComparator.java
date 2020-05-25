package B5_Advanced_Object.Thuc_Hanh.Comparator;

public class CricleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) {
            return 1;
        } else if (c1.getRadius() < c2.getRadius()) {
            return -1;
        } else {
            return 0;
        }

    }
}
