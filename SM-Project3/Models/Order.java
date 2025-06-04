package Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private Employee employee;
    private List<orderLine> orderLines;

    // Constructor
    public Order(Customer customer) {
        this.customer = customer;
        this.orderLines = new ArrayList<>();
    }

    // Getter og setter for customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Getter og setter for employee
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // Orderlines
    public List<orderLine> getOrderLines() {
        return orderLines;
    }

    public void addOrderLine(Product product, int quantity) {
        orderLine newLine = new orderLine(product, quantity);
        orderLines.add(newLine);
    }

    public void addUniqueOrderLine(UniqueProductCopy copy) {
        orderLine newLine = new orderLine(copy);
        orderLines.add(newLine);
    }
}
