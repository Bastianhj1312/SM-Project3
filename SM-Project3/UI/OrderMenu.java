package UI;
import Controllers.*;
import Models.*;
import java.util.ArrayList;

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
                boolean validPrivateCustomer = false;

                while (!validPrivateCustomer) {
                    int phoneNumber = TextInput.inputNumber("Tilføj kundens telefonnummer til ordren:");
                    PrivateCustomer privatecustomer = customercontroller.findCustomer(phoneNumber);
                    int staffID = TextInput.inputNumber("Tilføj staffid til ordren");
                    Employee employee = customercontroller.findEmployee(staffID);
                    if (privatecustomer != null && employee != null) {
                        orderController.addCustomertoOrder(phoneNumber);
                        orderController.addEmployeetoOrder(staffID);
                        validPrivateCustomer = true;
                        FlereKunder = false;
                    } else {
                        System.out.println("Ingen privatkunde fundet med dette telefonnummer. Prøv igen.");
                    }
                }

            } else if (kunder.equalsIgnoreCase("forretning")) {
                boolean validBusinessCustomer = false;

                while (!validBusinessCustomer) {
                    int cvr = TextInput.inputNumber("Tilføj kundens CVR-nummer til ordren:");
                    BusinessCustomer businessCustomer = customercontroller.findBusinessCustomer(cvr);

                    if (businessCustomer != null) {
                        orderController.addBusinessCustomerToOrder(cvr);
                        validBusinessCustomer = true;
                        FlereKunder = false;
                    } else {
                        System.out.println("Ingen forretning fundet med dette CVR-nummer. Prøv igen.");
                    }
                }
            } else if (kunder.equalsIgnoreCase("exit")) {
                System.out.println("Går tilbage til hovedmenu");
                start();
            } else {
                System.out.println("Ukendt kundetype. Prøv igen. Skriv enten 'privatkunde' eller 'forretning'.");
            }
        }

        boolean FlereProdukter = true;
        while (FlereProdukter) {
            int productNumber = TextInput.inputNumber("Indtast produktnummer");
            Product product = productcontroller.findProduct(productNumber);
            if (product != null) {
                if (product.isUniqueProduct()) {
                    boolean validSerial = false;
                    // finder unikt produkt
                    while (!validSerial) {
                        int serialNumber = TextInput.inputNumber("Indtast serienummer på det unikke produkt");
                        UniqueProductCopy match = productcontroller.findUniqueProductCopy(product.getProductNo(), serialNumber);
                        if (match != null) {
                            orderController.addUniqueProductToOrder(match);
                            validSerial = true;
                        }else {
                            System.out.println("Serienummeret passer ikke til produktet. Prøv igen.");
                        }
                    }
                } else {
                    int quantity = TextInput.inputNumber("Indtast mængde");
                    orderController.addProductToOrder(productNumber, quantity);
                }

                // Spørg om flere produkter
                boolean validAnswer = false;
                while (!validAnswer) {
                    String answer = TextInput.inputString("Vil du tilføje et produkt mere? (ja/nej)");

                    if (answer.equalsIgnoreCase("ja")) {
                        FlereProdukter = true;
                        validAnswer = true;
                    } else if (answer.equalsIgnoreCase("nej")) {
                        FlereProdukter = false;
                        validAnswer = true;
                    } else {
                        System.out.println("Ugyldigt svar. Skriv 'ja' eller 'nej'.");
                    }
                }
            } else {
                System.out.println("Produktet blev ikke fundet. Prøv igen.");
            }
        }
    }

    private void printOrder() {
        Order order = orderController.getOrder();
        System.out.println("Employee: " + order.getEmployee().getName() + " (ID :" + order.getEmployee().getStaffID());
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
