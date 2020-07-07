package B2_Mang_Va_Phuong_Thuc.Thuc_Hanh;

import java.util.Scanner;

public class su_dung_class_triang {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            System.out.println("InPut 3 canh của tam giác : ");
            System.out.println("Input a : ");
            int a = sc.nextInt();
            System.out.println("Input b : ");
            int b = sc.nextInt();
            System.out.println("Input c : ");
            int c = sc.nextInt();
            checkInput(a, b, c);
        } catch (Exception e) {
            System.out.println("Lỗi Input : " + e);
        }

        System.out.println("true");
    }

    static void checkInput(int a,int b,int c) {
        if (a < 0 || b < 0 || c < 0) {
            throw new ArithmeticException("a,b,c >0");
        }
        if (a + b < c || a + c < b || b + c < a) {
            throw new ArithmeticException("a+b>c");
        }
    }
}
