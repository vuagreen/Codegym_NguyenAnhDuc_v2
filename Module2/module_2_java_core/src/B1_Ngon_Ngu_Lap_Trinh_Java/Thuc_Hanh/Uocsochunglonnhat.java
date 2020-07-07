package B1_Ngon_Ngu_Lap_Trinh_Java.Thuc_Hanh;

import java.util.Scanner;

public class Uocsochunglonnhat {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a:");
        a = sc.nextInt();
        System.out.println("Enter b: ");
        b = sc.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            System.out.println(" No greatest common factor");

        }
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.println("Greatest common factor: " + a);
    }
}
