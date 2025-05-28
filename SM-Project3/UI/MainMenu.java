package UI;
import Models.*;
import Containers.*;
import Controllers.*;

public class MainMenu {
    private OrderController ordercontroller;
    private CustomerContainer customercontainer;
    private ProductContainer productcontainer;

    private OrderMenu orderMenu;;
    private CustomerUI customerMenu;

    public MainMenu() {
        orderMenu = new OrderMenu();;
        customerMenu = new CustomerUI();
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            int choice = writeMainMenu();
            if (choice == 1) {
                orderMenu.start();
            } else if (choice == 2) {
                orderMenu.start();
            } else if (choice == 3) {
                new TryMe().start();
              } else {
                writeEnd();
                exit = true;
            }
        }
    }

    private int writeMainMenu() {
        TextOptions menu = new TextOptions("\n *** Head menu ***", "Shutdown the program");
        menu.addOption("Customer menu");
        menu.addOption("Order menu");
        menu.addOption("Generating test data");
        return menu.prompt();
    }

    private void writeEnd() {
        System.out.println("Tak for denne gang");
    }
}

