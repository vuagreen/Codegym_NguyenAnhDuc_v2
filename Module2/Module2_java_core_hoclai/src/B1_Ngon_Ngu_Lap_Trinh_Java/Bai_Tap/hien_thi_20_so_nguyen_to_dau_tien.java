package B1_Ngon_Ngu_Lap_Trinh_Java.Bai_Tap;

import java.util.Scanner;

public class hien_thi_20_so_nguyen_to_dau_tien {
    public static void main(String[] args) {
        int count = 0;

        for (int i = 1; i < 1000; i++) {
            int dem = 0;
            for (int j = 1; j < 1000; j++) {
                if (i % j == 0) {
                    dem++;
                }
            }

            if (dem == 2) {
                System.out.println(i);
                count++;
                if (count == 20) {
                    break;
                }
            }
        }
    }
}

