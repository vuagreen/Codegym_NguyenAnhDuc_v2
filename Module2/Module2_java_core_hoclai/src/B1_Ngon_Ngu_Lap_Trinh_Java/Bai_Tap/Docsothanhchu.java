package B1_Ngon_Ngu_Lap_Trinh_Java.Bai_Tap;

import java.util.Scanner;

public class Docsothanhchu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number : ");
        String input = sc.nextLine();
        int number = Integer.parseInt(input);
        String text = "";
        if (input.length() <= 1) {
            if (number > 0 && number < 10) {

                switch (number) {
                    case 1:
                        text = "Một";
                        break;
                    case 2:
                        text = "Hai";
                        break;
                    case 3:
                        text = "Ba";
                        break;
                    case 4:
                        text = "Bốn";
                        break;
                    case 5:
                        text = "Năm";
                        break;
                    case 6:
                        text = "Sáu";
                        break;
                    case 7:
                        text = "Bảy";
                        break;
                    case 8:
                        text = "Tám";
                        break;
                    case 9:
                        text = "Chín";
                        break;

                }
            }
        } else if (input.length() <= 2) {
            switch (input.charAt(0)) {
                case '1':
                    text = "Mười ";
                    break;
                case '2':
                    text = "Hai Mươi ";
                    break;
                case '3':
                    text = "Ba Mươi ";
                    break;
                case '4':
                    text = "Bốn Mươi ";
                    break;
                case '5':
                    text = "Năm Mươi ";
                    break;
                case '6':
                    text = "Sáu Mươi ";
                    break;
                case '7':
                    text = "Bảy Mươi ";
                    break;
                case '8':
                    text = "Tám Mươi ";
                    break;
                case '9':
                    text = "Chín Mươi";
                    break;
            }
            switch (input.charAt(1)) {
                case '1':
                    text += "Mốt";
                    break;
                case '2':
                    text += "Hai";
                    break;
                case '3':
                    text += "Ba";
                    break;
                case '4':
                    text += "Bốn";
                    break;
                case '5':
                    text += "Năm";
                    break;
                case '6':
                    text += "Sáu";
                    break;
                case '7':
                    text += "Bảy";
                    break;
                case '8':
                    text += "Tám";
                    break;
                case '9':
                    text += "Chín";


            }
        }
        System.out.println(text);

    }
//    public static void doc1() {
//
//    }
}


