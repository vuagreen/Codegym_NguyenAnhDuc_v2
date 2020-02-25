package B2_Mang_Va_Phuong_Thuc.Bai_Tap;

import B2_Mang_Va_Phuong_Thuc.Thuc_Hanh.Tim_So_Lon_Nhat;

public class Cong_Mang {
    public static int[] array1;
    static int[] array2;
    static int[] array3;

    public static void plus() {
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (int j = 0; j < array2.length; j++) {
            array3[array1.length + j] = array2[j];
        }
    }

    public static void dis() {
        array3 = new int[array1.length + array2.length];
        plus();
        for (int i = 0; i < array3.length; i++) {
            System.out.println("Property List: \n");
            System.out.println(i + ". " + array3[i]);
        }
    }

    public static void main(String[] args) {
        array1 = Tim_So_Lon_Nhat.arrayOne2(10, array1);
        array2 = Tim_So_Lon_Nhat.arrayOne2(100, array2);
        Tim_So_Lon_Nhat.show2(array1);
        System.out.println("\n");
        Tim_So_Lon_Nhat.show2(array2);
        System.out.println("\n");
        dis();


    }
}
