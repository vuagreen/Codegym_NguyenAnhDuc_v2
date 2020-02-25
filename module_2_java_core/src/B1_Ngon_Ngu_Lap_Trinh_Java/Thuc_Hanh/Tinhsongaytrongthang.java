package B1_Ngon_Ngu_Lap_Trinh_Java.Thuc_Hanh;
import java.util.Scanner;

public class Tinhsongaytrongthang {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Month");
        int x = sc.nextInt();
        String day;
        if (13 > x && x > 0) {
            switch (x) {
                case 2:
                    day = "28 or 29";
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    day = "31";
                    break;
                default:
                    day = "30";
            }
        } else {
            day = "";
        }
        if (day != "") {
            System.out.printf("The month '%d' has %s day!", x, day);
        } else {
            System.out.println("ERRO");
        }

    }
}
