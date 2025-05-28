package UI;

import Containers.*;
import Controllers.*;
import Models.*;

public class Main {
    public static void main(String[] args) {
        // Initialize containers
        CustomerContainer customerContainer = CustomerContainer.getInstance();
        ProductContainer productContainer = ProductContainer.getInstance();

        // Create and add a customer
        Customer customer = new Customer("John Doe", 1234567890);
        customerContainer.saveCustomer(customer);

        // Create and add some products
        SimpleProduct product1 = new SimpleProduct(101, 50, "USB Cable", "Logitech", "X200", 20.0, "Supplier1", "SKU101", "a");
        SimpleProduct product2 = new SimpleProduct(102, 30, "Wireless Mouse", "Logitech", "M330", 25.0, "Supplier1", "SKU102", "a");

        productContainer.saveProduct(product1);
        productContainer.saveProduct(product2);

        // Create controller
        OrderController orderController = new OrderController();

        // Add customer to order (creates order)
        orderController.addCustomertoOrder(1234567890);

        // Add products to the order with quantities
        orderController.addProductToOrder(101, 2);
        orderController.addProductToOrder(102, 1);

        // Get the order
        Order order = orderController.getOrder();

        // Print order details
        System.out.println("Order created:");
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
}
