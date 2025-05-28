package UI;
import Controllers.*;


public class OrderMenu {
    private OrderController orderController;
    /**
     * Constructor for objects of class LoanMenu
     */
    public OrderMenu() {
        orderController = new OrderController();
        
       
    }
    
    public void start() {
        boolean running = true;
        while (running) {
            int choice = writeOrderMenu();
            if (choice == 1) {
                createOrder();
            } else if (choice == 2) {
                orderController.printCurrentOrders(); 
            } else {
                running = false;
            }
        }
    }
    
    //adds a search field to find a specific person from the data that has been given.
    private void createOrder() {
        int number = TextInput.inputNumber("Add Customer number to ordre");
        orderController.addCustomertoOrder(number);
        String product = TextInput.inputString("Add product to order");
        int productNumber = TextInput.inputNumber("tilføj produktnummer");
        int quantity = TextInput.inputNumber("indtast mængde");
        orderController.addProductToOrder(productNumber, quantity);
        confirmOrder();
    }
    
    private void confirmOrder() {
        boolean running = true;
        while (running) {
            
            int choice = writeConfirm();
            if (choice == 1) {
                orderController.orderConfirmed();
                running = false;
                start();
            } else {
                running = false;
            }
        }
    }
    
    private int writeConfirm() {
        TextOptions confirm = new TextOptions("\n ***** Confirm *****", "Cancel");
        confirm.addOption("Confirm");
        orderController.printOrderConfirmation();
        int choice = confirm.prompt();
        
        return choice;
        
    }

    private int writeOrderMenu() {
        // creates a keyboard object to read input
        TextOptions menu = new TextOptions("\n ***** Ordremenu *****", "Tilbage"); 
        menu.addOption("Opret en order");

        
        int choice = menu.prompt();

        return choice;
    }
}
