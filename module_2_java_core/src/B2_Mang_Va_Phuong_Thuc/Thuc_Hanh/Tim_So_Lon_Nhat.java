package B2_Mang_Va_Phuong_Thuc.Thuc_Hanh;

import java.util.Random;
import java.util.Scanner;

public class Tim_So_Lon_Nhat {
    static Scanner sc = new Scanner(System.in);
    public static int[] array;
    static Random number = new Random();

    public static int[] getArray() {
        return array;
    }public static int[] getArray2() {
        return array;
    }

    public static void arrayOne(int max) {
        int size;
        System.out.println("Enter Size Array");
        size = sc.nextInt();
        array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = number.nextInt(max);
        }
    }
    public static int[] arrayOne2(int max,int[] array1) {
        int size;
        System.out.println("Enter Size Array");
        size = sc.nextInt();
        array1 = new int[size];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = number.nextInt(max);
        }

        return array1;
    }

    public static void show(int[] array) {
        System.out.println("Property list: ");
        for (int x : array) {
            System.out.print( x+ " ");
        }

    }
    public static void show2(int[] array1) {
        System.out.println("Property list: ");
        for (int x : array1) {
            System.out.print( x+ " ");
        }

    }

    public static void max() {
        int max;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    max = array[i];
                    array[i] = array[j];
                    array[j] = max;
                }
            }

        }

    }

    public static void showMax() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[array.length - 1]) {
                System.out.println(" Max = " + array[i] + " location :" + i);
            }
        }
    }

    public static void showMin() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[0]) {
                System.out.println("Min = " + array[i] + " location :" + i);
            }
        }
    }


    public static void main(String[] args) {
        arrayOne(1000);
        max();
        show(array);
        showMax();

    }
}
