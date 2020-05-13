package B2_Mang_Va_Phuong_Thuc.Thuc_Hanh;

import java.util.Random;
import java.util.Scanner;

public class Tim_Phan_Tu_Lon_Nhat_Mang_2_Chieu {
    static int[][] array;
    static Random number = new Random();
    static Scanner sc = new Scanner(System.in);
    static int width;
    static int height;

    public static int[][] getArray() {
        return array;
    }

    public static void arrayTwo(int max) {
        System.out.println("Enter Height Array");
        height = sc.nextInt();
        System.out.println("Enter Width Array");
        width = sc.nextInt();
        array = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                array[i][j] = number.nextInt(max);
            }
        }
    }


    public static void minToMaxArrayTwo() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {
                    for (int t = 0; t < width; t++) {
                        if (array[i][j] < array[k][t]) {
                            int max = array[i][j];
                            array[i][j] = array[k][t];
                            array[k][t] = max;
                        }
                    }
                }

            }
        }
    }

    public static void showArrayTwo() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" " + array[i][j]);
                if (array[i][j] < 10) {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }

    public static void showMax2dArray() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (array[i][j] == array[array.length - 1][array[0].length - 1]) {
                    System.out.println("Max = " + array[i][j] + " location : i= " + i + " j=" + j);
                }
            }
        }
    }

    public static void showMax() {
        int max = array[0][0];
        int index1=0;
        int index2=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    index1 = i+1;
                    index2 = j+1;
                }
            }
        }
        System.out.println("Max = "+max +" location : Hàng = "+index1+" Cột =: "+index2);
    }


    public static void main(String[] args) {
        arrayTwo(100);
        showArrayTwo();
        showMax();
        System.out.println(" ");
        minToMaxArrayTwo();
        showArrayTwo();
        showMax2dArray();
    }
}

