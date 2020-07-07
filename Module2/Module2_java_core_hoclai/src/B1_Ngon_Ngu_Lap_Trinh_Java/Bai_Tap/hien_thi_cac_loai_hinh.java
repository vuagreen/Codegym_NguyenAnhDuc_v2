package B1_Ngon_Ngu_Lap_Trinh_Java.Bai_Tap;

import java.util.Scanner;

public class hien_thi_cac_loai_hinh {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showmenu();
    }

    public static void showmenu() {
        System.out.println("MENU");
        System.out.println("1.Print the rectangle \n" +
                "2.Print the square triangle \n" +
                "3.Print isosceles triangle \n" +
                "4.Exit ");
        int num = sc.nextInt();
        System.out.println("Input Width :");
        int width = sc.nextInt();
        System.out.println("Input Height :");
        int height = sc.nextInt();
        switch (num) {
            case 1:
                retangle(width, height);
                break;
            case 2:
                square_triangle(width, height);
                break;

            case 3:
                isosceles_triangle(width, height);
                break;
            case 4:
                System.out.println("Exit ");
                break;
            case 5:
                triangle(width, height);
        }

    }

    private static void retangle(int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    private static void square_triangle(int width, int height) {
        int h2 = height - 1;
        for (int i = 0; i < width; i++) {
            for (int j = h2; j < height; j++) {
                System.out.print("* ");
            }
            System.out.println("");
            h2 -= 1;
        }

    }

    private static void isosceles_triangle(int width, int height) {
        int h2 = 0;
        for (int i = 0; i < width; i++) {
            for (int j = h2; j < height; j++) {
                System.out.print("* ");
            }
            System.out.println("");
            h2 += 1;
        }
    }

    private static void triangle(int width, int height) {
        int p=1;
        for (int n = 1; n <= height; n++) {
            for (int i = 1; i <= height - p; i++) {
                System.out.print(" ");


            }
            for (int j = 1; j <= (2 * n - 1); j++) {
                System.out.print("*");


            }
            System.out.println("");
            p++;

        }


    }

}



