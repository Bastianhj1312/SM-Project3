package Containers;
import Models.*;
import java.util.ArrayList;

/**
 * Write a description of class CustomerContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomerContainer
{
   private ArrayList<Customer> customers;
   private static CustomerContainer instance;
   
   private CustomerContainer(){
       customers = new ArrayList<>();
   }
   public static CustomerContainer getInstance(){
       if(instance == null){
           instance = new CustomerContainer();
       }
       return instance;
   }
   public void saveCustomer(Customer customer){
       customers.add(customer);
   }
   public Customer findCustomer(int phone){
       Customer customer = null;
       boolean found = false;
       int i = 0;
       while(!found && i < customers.size()){
           Customer c = customers.get(i);
           if(c.getPhone()==phone){
               customer = c;
               found = true;
           }
           else {
               i++;
           }
       }
       return customer;
   }
}
