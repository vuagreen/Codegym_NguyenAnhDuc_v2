package B1_Ngon_Ngu_Lap_Trinh_Java.Bai_Tap;

import java.util.Scanner;

public class Hienthicacsonguyentonhohon100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=2; i < 100; i++) {
            int dem = 0;
            for (int j=1; j < 100; j++) {
                int a = i%j;
                if (a == 0) {
                    dem++;
                }
            }
            if (dem <= 2) {
                System.out.println(i+"La so nguyen to");
            }

        }
    }
}
