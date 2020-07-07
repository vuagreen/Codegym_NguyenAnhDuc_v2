package B1_Ngon_Ngu_Lap_Trinh_Java.Thuc_Hanh;

import java.util.Scanner;

public class Tinhlai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = 1.0;
        int month = 1;
        double interset_rate = 5.5;
        System.out.println("Enter investment amount: ");
        money = sc.nextDouble();
        System.out.println("Enter number of months: ");
        month = sc.nextInt();
        double total_interset = 0;
        for(int i = 0; i < month; i++){
            total_interset = money * (interset_rate/100)/12 * month;
            System.out.println("Total of interset: " + total_interset);
        }
    }
}
