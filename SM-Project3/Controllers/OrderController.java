package Controllers;

import Containers.*;
import Models.*;

public class OrderController {
    CustomerContainer customercontainer;
    ProductContainer productcontainer;
    Order order;

    public OrderController() {
        customercontainer = CustomerContainer.getInstance();
        productcontainer = ProductContainer.getInstance();
    }

    public Customer addCustomertoOrder(int phone) {
        Customer customer = customercontainer.findCustomer(phone);
        order = new Order(customer);
        return customer;
    }

    public Order addProductToOrder(int productNo, int quantity) {
        Product product = productcontainer.findProduct(productNo);
        order.addOrderLine(product, quantity);
        return order;
    }

    public Order getOrder() {
        return order;
    }
}
