package B2_Mang_Va_Phuong_Thuc.Thuc_Hanh;

import java.util.Scanner;

public class Chuyen_Doi_Nhiet_Do {
    static Scanner sc = new Scanner(System.in);

    public static double cToF(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;

    }

    public static double fToC(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }

    public static void Menu() {
        int choice;
        do {
            System.out.println("Menu.");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Fahrenheit :");
                    double fahrenheit = sc.nextDouble();
                    System.out.println("Fahrenheit to Celsius = " + fToC(fahrenheit));
                    break;
                case 2:
                    System.out.println("Enter Celsius: ");
                    double celsius = sc.nextDouble();
                    System.out.println("Celsius to Fahrenheit = " + cToF(celsius));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);

    }

    public static void main(String[] args) {
        Menu();

    }

}
