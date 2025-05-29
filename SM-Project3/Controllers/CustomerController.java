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
    public void saveCustomer(PrivateCustomer customer) {
        customercontainer.savePrivateCustomer(customer);
    }
    public void saveBusinessCustomer(BusinessCustomer customer) {
        customercontainer.saveBusinessCustomer(customer);
    }
    public PrivateCustomer findCustomer(int phone){
        return customercontainer.findPrivateCustomer(phone); 
    }
    public BusinessCustomer findBusinessCustomer(int cvr){
        return customercontainer.findBusinessCustomer(cvr); 
    }
}
