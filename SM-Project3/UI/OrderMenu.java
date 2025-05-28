package UI;
import Controllers.*;
import Models.*;


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
            } else if(choice == 2){
                printOrder();
            }else {
                running = false;
            }
        }
    }
    
    //adds a search field to find a specific person from the data that has been given.
    private void createOrder() {
        int phoneNumber = TextInput.inputNumber("Add Customer phone number to ordre");
        orderController.addCustomertoOrder(phoneNumber);
        int productNumber = TextInput.inputNumber("tilføj produktnummer");
        int quantity = TextInput.inputNumber("indtast mængde");
        orderController.addProductToOrder(productNumber, quantity);
    }
    
    private void printOrder(){
        Order order = orderController.getOrder();
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Order lines:");

        for (orderLine ol : order.getOrderLines()) {
            Product p = ol.getProduct();
            int quantityOrdered = ol.getQuantity();

            System.out.println("Product No: " + p.getProductNo());
            System.out.println("Product Name: " + ((SimpleProduct) p).getProductName());
            System.out.println("Quantity ordered: " + quantityOrdered);
            System.out.println("Price per unit: " + ((SimpleProduct) p).getRecommendedRetailPrice());
            System.out.println("Line total: " + quantityOrdered * ((SimpleProduct) p).getRecommendedRetailPrice());
            System.out.println("-----");
        }

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
        menu.addOption("Print Kvittering");

        
        int choice = menu.prompt();

        return choice;
    }
    
}
