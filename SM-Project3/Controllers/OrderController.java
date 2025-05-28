package Controllers;
import Containers.*;
import Models.*;

public class OrderController {
    CustomerController customercontroller;
    ProductController productcontroller;
    Order order;

    public OrderController() {
        customercontroller = new CustomerController();
        productcontroller = new ProductController();
    }

    public Customer addCustomertoOrder(int phone) {
        Customer customer = customercontroller.findCustomer(phone);
        order = new Order(customer);
        return customer;
    }

    public Order addProductToOrder(int productNo, int quantity) {
        Product product = productcontroller.findProduct(productNo); 
        
        if(product == null){
            System.out.println("Product is null");
        }else{
            order.addOrderLine(product, quantity);
        }  
        return order;
    }

    public Order getOrder() {
        return order;
    }
}
