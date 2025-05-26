package Containers;
import java.util.ArrayList;

public class OrderContainer {
    // Singleton instance
    private static OrderContainer instance;

    // List of orders
    private ArrayList<Order> orders;

    // Private constructor
    private OrderContainer() {
        orders = new ArrayList<Order>();
    }

    // Public method to get the single instance
    public static OrderContainer getInstance() {
        if (instance == null) {
            instance = new OrderContainer();
        }
        return instance;
    }

    // Method to add an order
    public void addOrder(Customer customer) {
        Order newOrder = new Order(customer);
        orders.add(newOrder);
    }

    // Method to find an order by staff ID
    public Order findOrder(int staffID) {
        for (Order order : orders) {
            if (order.getStaffID() == staffID) {
                return order;
            }
        }
        return null;
    }

    // Method to check delivered status
    public void checkDelivered(boolean delivered) {
        for (Order order : orders) {
            if (order.isDelivered() == delivered) {
                System.out.println("Order found with delivery status: " + delivered);
                // Add more logic here if needed
            }
        }
    }
}
