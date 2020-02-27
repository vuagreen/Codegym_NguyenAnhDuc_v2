package phone;

import java.util.Scanner;

public class MainController {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        addPhone();

    }

    public static void addPhone() {
        Phone phone = new Phone();
        System.out.println("asdsd");
        phone.setId(Validation.checkAndGetNumber("Id is invalid !!! please try again"));
    }
}
