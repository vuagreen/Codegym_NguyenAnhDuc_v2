package phone;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
    public static int checkAndGetNumber(String contentError) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(contentError);
            }
        }
    }
}
