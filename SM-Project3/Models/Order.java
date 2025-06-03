package Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int staffID;
    private List<orderLine> orderLine;
    private Customer customer;
    private Product product; // optional single product

    // Constructor
    public Order(Customer customer) {
        this.customer = customer;
        this.product = product;
        this.staffID = staffID;
        this.orderLine = new ArrayList<>();
    }

    // Getter and setter
    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Add a product to the list
    public void addOrderLine(Product p, int quantity) {
        orderLine newOrderLine = new orderLine(p, quantity);
        orderLine.add(newOrderLine);
    }

    public Customer getCustomer() {
        return customer;
    }
    public Product getProduct(){
        return product;
    }

    public List<orderLine> getOrderLines() {
        return orderLine;
    }
}
