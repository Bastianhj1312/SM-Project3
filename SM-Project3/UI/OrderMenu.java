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
            } else {
                running = false;
            }
        }
    }
    
    //adds a search field to find a specific person from the data that has been given.
    private void createOrder() {
        int phoneNumber = TextInput.inputNumber("Add Customer phoneNumber to ordre");
        orderController.addCustomertoOrder(phoneNumber);
        int productNumber = TextInput.inputNumber("tilføj produktnummer");
        int quantity = TextInput.inputNumber("indtast mængde");
        orderController.addProductToOrder(productNumber, quantity);
    }
    
    
    private int writeConfirm() {
        TextOptions confirm = new TextOptions("\n ***** Confirm *****", "Cancel");
        confirm.addOption("Confirm");
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
