package Models;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int staffID;
    private List<orderLine> orderLine;
    private Customer customer;

    // Constructor
    public Order(Customer customer, int staffID) {
        this.customer = customer;
        this.staffID = staffID;
        this.orderLine = new ArrayList<>();
    }

    // Getter for staffID
    public int getStaffID() {
        return staffID;
    }

    // Setter for staffID
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    // Method to add an order line
    public void addOrderLine(Product p, int quantity) {
        orderLine newOrderLine = new orderLine(p, quantity);
        orderLine.add(newOrderLine);
    }
}