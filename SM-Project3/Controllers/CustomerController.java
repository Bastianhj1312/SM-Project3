package Controllers;
import Models.*;
import Containers.*;

/**
 * Write a description of class CustomerController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomerController
{
    CustomerContainer customercontainer;
    Customer customer;

    public CustomerController(){
        customercontainer = CustomerContainer.getInstance();
    }
    public void saveCustomer(Customer customer) {
        customercontainer.saveCustomer(customer);
    }
    public Customer findCustomer(int phone){
        return customercontainer.findCustomer(phone); 
    }
}
