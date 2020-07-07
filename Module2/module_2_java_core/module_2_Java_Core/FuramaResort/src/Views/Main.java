package Views;

import Commons.Sc;
import Controllers.MainController;

public class Main {
    static Sc sc = new Sc();
    public static void main(String[] args) {
        MainController mainController =new MainController();
        mainController.displayMainMenu();
    }
}
