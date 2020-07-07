package B2_Mang_Va_Phuong_Thuc.Thuc_Hanh;

import java.util.Scanner;

public class Add_Array {
    static Scanner sc = new Scanner(System.in);
    static int[] array = new int[10];

    public static void inputArray() {
        int x;
        int y;
        System.out.println("Nhap Gia Tri");
        x = sc.nextInt();
        System.out.println("Nhap vi tri can chen : ");
        y = sc.nextInt();
        array[y] = x;
    }

    public static void showArray() {
        System.out.println("Property list: ");
        for (int x : array) {
            System.out.println(" " + x);
        }

    }

    public static void main(String[] args) {
        inputArray();
        showArray();
    }
}
