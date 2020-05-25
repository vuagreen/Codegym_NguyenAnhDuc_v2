package Views;

import Controllers.MainController;
import Models.Villa;

public class Main {

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}
