package B1_Ngon_Ngu_Lap_Trinh_Java.Thuc_Hanh;

import java.util.Scanner;

public class Tim_kiem_gia_tri_trong_mang {
    public static void main(String[] args) {
        String[] student = {"abc", "xyz", "duc", "hung"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.nextLine();
        System.out.println(trues(student,name));

    }

    public static String trues(String[] student,String name) {

        for (int i = 0; i < student.length; i++) {
            if (student[i].equals(name)) {
               return "Position of the students in the list " + name + " is: " + (i + 1);
            }
        }
        return "Not found" + name + " in the list.";

    }
}

