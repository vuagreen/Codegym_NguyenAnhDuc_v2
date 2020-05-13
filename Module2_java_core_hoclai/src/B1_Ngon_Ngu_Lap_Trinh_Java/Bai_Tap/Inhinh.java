package B1_Ngon_Ngu_Lap_Trinh_Java.Bai_Tap;

import java.util.Scanner;

public class Inhinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu " +
                "\n1.HinhChuNhat" +
                "\n2.InHinhTamGiacVuongBot" +
                "\n3.InHinhTamGiacVuongTop");
        int x = sc.nextInt();
        System.out.println("Enter Height : ");
        int height = sc.nextInt();
        System.out.println("Enter Weight : ");
        int weight = sc.nextInt();
        switch (x) {
            case 1:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < weight; j++) {
                        System.out.print("* ");
                    }
                    System.out.println("");

                }
                break;
            case 2:
                int weight2=1;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < weight2; j++) {
                        System.out.print("* ");
                    }
                    System.out.println("");
                    weight2++;
                    if (weight2>weight) {
                        break;

                    }

                }break;
            case 3:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < weight; j++) {
                        System.out.print("* ");
                    }
                    System.out.println("");
                    weight--;
                    if (weight == 0) {
                        break;
                    }

                }

        }

    }
}
