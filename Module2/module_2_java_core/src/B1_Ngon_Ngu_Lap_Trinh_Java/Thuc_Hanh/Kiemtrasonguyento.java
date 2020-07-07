package B1_Ngon_Ngu_Lap_Trinh_Java.Thuc_Hanh;

import java.util.Scanner;

public class Kiemtrasonguyento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number : ");
        int number = sc.nextInt();
        if (number < 2) {
            System.out.println(number + " is not Prime");
        } else {
            int i=2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                System.out.println(number + " is Prime");
            } else {
                System.out.println(number+ " is not Prime");

            }
        }
    }
}
