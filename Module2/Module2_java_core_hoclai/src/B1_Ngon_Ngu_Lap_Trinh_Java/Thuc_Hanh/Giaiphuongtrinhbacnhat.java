package B1_Ngon_Ngu_Lap_Trinh_Java.Thuc_Hanh;

import java.util.Scanner;

public class Giaiphuongtrinhbacnhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a*x+b=0 ");
        System.out.println("Enter a :");
        double a = sc.nextDouble();
        System.out.println("Enter b: ");
        double b = sc.nextFloat();
        double x;
        if (a != 0) {
            x = -b / a;
            System.out.printf("X = %f", x);
        } else {
            if (b == 0) {
                System.out.println("All X");
            } else {
                System.out.println("Null");
            }

        }
    }
}
