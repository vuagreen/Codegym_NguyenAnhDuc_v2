package B2_Mang_Va_Phuong_Thuc.Bai_Tap;

import B2_Mang_Va_Phuong_Thuc.Thuc_Hanh.Tim_So_Lon_Nhat;

public class Tim_Min {


    public static void main(String[] args) {
//        Tim_So_Lon_Nhat.arrayOne(100);
//        Tim_So_Lon_Nhat.max();
//        Tim_So_Lon_Nhat.show(Tim_So_Lon_Nhat.getArray());
//        Tim_So_Lon_Nhat.showMin();

        int point = 3598;
        int point2 = 762*5;
        double gem = 0.0;
        int day = 90;
        int month = 1;
        int countDay = 0;
        int x = 5;
        double a = 0.2/100;
        double b = 0.1/100;
        while (countDay < day) {
            point = point2;
            countDay++;
            gem += a * point;
//            System.out.println("gem Day"+countDay+" = " +gem +"  Số % = "+a);
            if (countDay % 30==0) {
                System.out.println(" Tổng tiền sau " + month + " tháng = " + gem);
                month++;
//                point += gem * x;
//                x--;
//                gem = 0.0;
            }
            point-=a*point;
            if (countDay == 180) {
                a = b;
            }

        }
        System.out.println("Tổng Gem sau "+countDay+" day ="+gem +"$" );
        System.out.println("Số Point còn lại :" +point);

    }

}
