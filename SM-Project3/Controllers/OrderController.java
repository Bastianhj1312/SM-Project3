package Controllers;
import Containers.*;
import Models.*;
/**
 * Write a description of class OrderController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrderController
{
    CustomerContainer customercontainer;
    ProductContainer productcontainer;
    Order order;
    public Customer addCustomertoOrder(int phone){
        Customer customer = customercontainer.findCustomer(phone);
        order.setCustomer(customer);
        return customer;
    }
    public Order addProductToOrder(int productNo){
        Product product = productcontainer.findProduct(productNo);
        order.setProduct(product);
        return order;
    }
}
