package CaseStudy_Module2.Commons;

import java.util.Scanner;

public class FuncValidation {
    private static String regex = "";
    private static Scanner sc;

    //check Name Valid
    public static boolean checkNameService(String string) {
        regex = "^([A-Z][a-z0-9]*)|([A-Z][a-z0-9]*\\s([A-Z][a-z0-9]*))$";
        return string.matches(regex);
    }

    //Check Number Double
    public static double checkNumberDouble(String content, String errmes) {
        while (true) {
            try {
                sc = new Scanner(System.in);
                System.out.println(content);
                return sc.nextDouble();
            } catch (Exception ex) {
                System.out.println(errmes + "\n(" + ex + ")");
            }
        }
    }

    //Check Number Int
    public static Integer checkNumberInteger(String content, String errmes) {
        while (true) {
            try {
                sc = new Scanner(System.in);
                System.out.println(content);
                return sc.nextInt();
            } catch (Exception ex) {
                System.out.println(errmes + "\n(" + ex + ")");
            }
        }
    }

    public static boolean checkFreeService(String string) {
        regex="massage|karaoke|food|drink|car";
        return string.matches(regex);

    }

    public static boolean checkBirthday(String string) {
        regex = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
        return string.matches(regex);
    }

    public static boolean checkEmail(String string) {
        regex = "^\\w+[a-zA-Z0-9]+@[a-z]+mail.com$";
        return string.matches(regex);
    }




}
