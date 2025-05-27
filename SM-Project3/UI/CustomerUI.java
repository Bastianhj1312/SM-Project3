package UI;
import Models.*;
import Containers.*;
import Controllers.*;
import java.util.Scanner;
//import TextOptions;


/**
 * Write a description of class CustomerUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomerUI
{
    private CustomerController customercontroller;
    
    public CustomerUI(){
        customercontroller = new CustomerController();
    }
    
    public void start() {
        customerMenu();
    }
    
    private void customerMenu() {
       boolean exit = false;
       while(!exit) {
          int choice = writeCustomerMenu(); 
          if(choice == 1) { //create the customer
            createCustomer();
          }
          else if (choice == 2) { //find the customer
            System.out.println("Denne skal implementeres når du når til den øvelse!");
          } 
          else {
            exit = true;
            System.out.println("Fortsat god dag.");
          }//end else  
       }//end while
    }
    
    private String inputCustomerName() {
         // makes an object keyboard to have input from the screen
         Scanner keyboard = new Scanner(System.in);  
         System.out.println(" Indtast navn på kunden:  ");
         String name = keyboard.nextLine();
         return name;
    }
    
    private String inputCustomerPhone() {
        // makes an object keyboard to read input from the console
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast kundens telefonnummer: ");
        String phone = keyboard.nextLine();
        return phone;
    }
    
    private void createCustomer() {
        String name = TextInput.inputString();
        String phone = inputCustomerPhone();
        customercontroller.saveCustomer(name, phone);
    }  

}
