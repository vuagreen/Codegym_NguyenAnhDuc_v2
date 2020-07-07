package B3_Lop_Va_Doi_Tuong.Thuc_Hanh.Lop_Hinh_Chu_Nhat;

import java.util.Scanner;

public class Dis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Width: ");
        double width = sc.nextDouble();
        System.out.println("Enter Height: ");
        double height = sc.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());

    }
}
