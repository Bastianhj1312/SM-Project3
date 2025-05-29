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
   private ArrayList<PrivateCustomer> privatecustomers;
   private ArrayList<BusinessCustomer> businesscustomers;
   private static CustomerContainer instance;
   
   private CustomerContainer(){
       privatecustomers = new ArrayList<>();
       businesscustomers = new ArrayList<>();
   }
   public static CustomerContainer getInstance(){
       if(instance == null){
           instance = new CustomerContainer();
       }
       return instance;
   }
   public void savePrivateCustomer(PrivateCustomer privatecustomer){
       privatecustomers.add(privatecustomer);
   }
   public void saveBusinessCustomer(BusinessCustomer businesscustomer){
       businesscustomers.add(businesscustomer);
   }
   public PrivateCustomer findPrivateCustomer(int phone) {
    PrivateCustomer customer = null;
    boolean found = false;
    int i = 0;

    while (!found && i < privatecustomers.size()) {
        PrivateCustomer c = privatecustomers.get(i);
        if (c.getPhone() == phone) {
            customer = c;
            found = true;
        } else {
            i++;
        }
    }

    return customer;
}
public BusinessCustomer findBusinessCustomer(int cvr) {
    BusinessCustomer customer = null;
    boolean found = false;
    int i = 0;

    while (!found && i < businesscustomers.size()) {
        BusinessCustomer c = businesscustomers.get(i);
        if (c.getCvr() == cvr) {
            customer = c;
            found = true;
        } else {
            i++;
        }
    }

    return customer;
}

}

