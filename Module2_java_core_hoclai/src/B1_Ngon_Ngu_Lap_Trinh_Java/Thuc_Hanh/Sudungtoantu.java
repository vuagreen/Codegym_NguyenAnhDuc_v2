package B1_Ngon_Ngu_Lap_Trinh_Java.Thuc_Hanh;

import java.util.Scanner;

public class Sudungtoantu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float width;
        float height;
        System.out.println("Enter Width : ");
        width = sc.nextFloat();
        System.out.println("Enter Height: ");
        height = sc.nextFloat();
        float s = width * height;
        System.out.println("S= " + s);

    }


}
