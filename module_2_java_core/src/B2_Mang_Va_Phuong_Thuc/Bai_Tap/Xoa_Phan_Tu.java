package B2_Mang_Va_Phuong_Thuc.Bai_Tap;

import B2_Mang_Va_Phuong_Thuc.Thuc_Hanh.Tim_So_Lon_Nhat;

import java.util.Scanner;

public class Xoa_Phan_Tu {
    static int[] array;
    static Scanner sc = new Scanner(System.in);
    static int index;

    static void check() {
        System.out.println("Enter Number");
        int num = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                index = i;
                for (int j = index; j < (array.length - 1); j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
                System.out.println(array.length + "," + index);
                i--;
            }
        }


    }

    public static void main(String[] args) {
        Tim_So_Lon_Nhat.arrayOne(10);
        array = Tim_So_Lon_Nhat.getArray();
        Tim_So_Lon_Nhat.show3();
        check();
        Tim_So_Lon_Nhat.show3();
    }
}
