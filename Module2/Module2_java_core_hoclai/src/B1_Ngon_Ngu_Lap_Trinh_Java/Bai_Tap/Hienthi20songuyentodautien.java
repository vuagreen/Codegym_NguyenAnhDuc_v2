package B1_Ngon_Ngu_Lap_Trinh_Java.Bai_Tap;

import java.util.Scanner;

public class Hienthi20songuyentodautien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Show :");
        int count1 = sc.nextInt();
        int count=0;
        for (int i=2; i < 100; i++) {
            int dem = 0;
            for (int j=1; j < 100; j++) {
                int a = i%j;
                if (a == 0) {
                    dem++;
                }
            }
            if (dem <= 2) {
                System.out.println("Số Nguyên Tố Thứ "+(count+1)+"Là : "+i);
                count++;
                if (count == count1) {
                    break;
                }
            }

        }
    }
}
