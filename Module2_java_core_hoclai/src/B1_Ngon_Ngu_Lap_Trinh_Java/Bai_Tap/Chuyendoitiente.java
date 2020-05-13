package B1_Ngon_Ngu_Lap_Trinh_Java.Bai_Tap;

import java.util.Scanner;

public class Chuyendoitiente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Money (USD) : ");
        double input = sc.nextDouble();
        double vnd=input*23000;
        System.out.println(input+" USD = "+vnd +"VND");
    }
}
