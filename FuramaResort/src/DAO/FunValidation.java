package DAO;

import java.util.Scanner;

public class FunValidation {
    public static Scanner scanner = new Scanner(System.in);
    public static String regex;

    public static <T> T checkValidate(String content, String errMes, String regex) {
        while (true) {
            try {
                System.out.println(content);
                T inputValue;
                inputValue = (T) scanner.nextLine();
                if (inputValue.toString().matches(regex)) {
                    return (T) inputValue;
                } else {
                    System.out.println(errMes);
                }
            } catch (Exception e) {
                System.out.println(errMes+e);
                FunValidation.checkValidate(content, errMes, regex);
            }
        }
    }
    //Check name validate
    public static boolean checkNameService(String str) {
         regex = "^[A-Z][a-z]+\\s*\\w*$";
        return str.matches(regex);
    }

    //check Number double
    public static double checkValidateNumberDouble(String content, String errMes) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println(errMes+e);
            }
        }
    }

    public static int checkValidateNumberInt(String content, String errMes) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println(errMes+e);
            }
        }
    }
}
