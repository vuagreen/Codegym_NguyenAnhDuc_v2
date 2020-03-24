package B4_Ke_Thua.BaiTap.ClassCircle;

public class testCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(5, "red", 6);
        System.out.println(cylinder);
        cylinder = new Cylinder(10, "black", 7);
        System.out.println(cylinder);
    }
}
