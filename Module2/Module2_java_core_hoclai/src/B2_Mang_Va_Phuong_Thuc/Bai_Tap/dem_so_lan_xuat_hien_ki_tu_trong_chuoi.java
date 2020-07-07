package B2_Mang_Va_Phuong_Thuc.Bai_Tap;

import java.util.Scanner;

public class dem_so_lan_xuat_hien_ki_tu_trong_chuoi {
    static Scanner sc = new Scanner(System.in);
    static String name = "hoc java core";
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(" Nhập Kí Tự Cần Đếm : ");
        String x = sc.nextLine();
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == x.charAt(0)) {
                count++;
            }

        }
        System.out.println(count);
    }
}
