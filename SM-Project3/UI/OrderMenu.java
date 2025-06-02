package UI;
import Controllers.*;
import Models.*;

public class OrderMenu {
    private OrderController orderController;
    private ProductController productcontroller;
    private CustomerController customercontroller;
    /**
     * Constructor for objects of class LoanMenu
     */
    public OrderMenu() {
        orderController = new OrderController();
        productcontroller = new ProductController();
        customercontroller = new CustomerController();
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
        boolean FlereKunder = true;

        while (FlereKunder) {
            String kunder = TextInput.inputString("Vil du tilføje en privatkunde eller forretning til ordren?");

            if (kunder.equalsIgnoreCase("privatkunde")) {
                int phoneNumber = TextInput.inputNumber("Tilføj kundens telefonnummer til ordren:");
                // Find kunden i databasen eller kundelisten
                PrivateCustomer privatecustomer = customercontroller.findCustomer(phoneNumber);

                if (privatecustomer != null) {
                    orderController.addCustomertoOrder(phoneNumber);
                    FlereKunder = false;
                } else {
                    System.out.println("Ingen privatkunde fundet med dette telefonnummer. Prøv igen.");
                }

            } else if (kunder.equalsIgnoreCase("forretning")) {
                int cvr = TextInput.inputNumber("Tilføj kundens CVR-nummer til ordren:");
                orderController.addBusinessCustomerToOrder(cvr);
                FlereKunder = false;

            } else {
                System.out.println("Ukendt kundetype. Prøv igen.");
            }
        }

        boolean FlereProdukter = true;

        while (FlereProdukter) {
            int productNumber = TextInput.inputNumber("Indtast produktnummer");

            Product product = productcontroller.findProduct(productNumber);

            if (product.isUniqueProduct()) {
                int serialNumber = TextInput.inputNumber("Indtast serienummer på det unikke produkt");
                orderController.addUniqueProductToOrder((UniqueProduct) product, serialNumber);
            } else {
                int quantity = TextInput.inputNumber("Indtast mængde");
                orderController.addProductToOrder(productNumber, quantity);
            }

            String answer = TextInput.inputString("Vil du tilføje et produkt mere? (ja/nej)");

            if (answer.equals("ja")) {
                FlereProdukter = true;
            } else if (answer.equals("nej")) {
                FlereProdukter = false;
            } else {
                System.out.println("Du skrev forkert, prøv igen.");
            }
        }
    }

    private void printOrder() {
        Order order = orderController.getOrder();
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Order lines:");

        double totalOrderPrice = 0.0;

        for (orderLine ol : order.getOrderLines()) {
            Product p = ol.getProduct();
            System.out.println("Product No: " + p.getProductNo());
            System.out.println("Product Name: " + p.getProductName());
            System.out.println("Quantity: " + ol.getQuantity());
            System.out.println("Price per unit: " + p.getSellingPrice());
            System.out.println("Line total: " + ol.getLineTotal());
            totalOrderPrice += ol.getLineTotal();

            // Print serial number if it's a unique product copy
            if (ol.isUnique()) {
                System.out.println("Serial Number: " + ol.getUniqueProductCopy().getSerialNumber());
            }

            System.out.println("-----");
        }

        // Print samlet pris
        System.out.println("Total pris for hele ordren: " + totalOrderPrice + " kr");
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
