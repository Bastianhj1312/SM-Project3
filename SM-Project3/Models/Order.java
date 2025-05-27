package Models;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int staffID;
    private List<orderLine> orderLine;
    private Customer customer;
    private Product product;
    private boolean delivered;

    // Constructor
    public Order(Customer customer, int staffID, Product product) {
        this.customer = customer;
        this.product = product;
        this.staffID = staffID;
        this.orderLine = new ArrayList<>();
        this.delivered = delivered;
    }

    // Getter for staffID
    public int getStaffID() {
        return staffID;
    }
    public boolean isDelivered(){
        return delivered;
    }
    // Setter for staffID
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setProduct(Product product){
        this.product = product;
    }

    // Method to add an order line
    public void addOrderLine(Product p, int quantity) {
        orderLine newOrderLine = new orderLine(p, quantity);
        orderLine.add(newOrderLine);
    }
}