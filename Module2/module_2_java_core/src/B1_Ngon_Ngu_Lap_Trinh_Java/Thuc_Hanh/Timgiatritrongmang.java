package B1_Ngon_Ngu_Lap_Trinh_Java.Thuc_Hanh;

import java.util.Scanner;

public class Timgiatritrongmang {
    public static void main(String[] args) {
        String[] Student = {"abc", "abcd", "hki", "supper"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String input_name = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < Student.length; i++) {
            if (Student[i].equals(input_name)) {
                System.out.println("output  : " + input_name + " is " + (i + 1));
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Not Found "+input_name+"int the list");

        }
    }
}
