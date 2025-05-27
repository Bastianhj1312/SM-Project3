package UI;
import Models.*;
import Containers.*;
import Controllers.*;
import java.util.Scanner;


/**
 * Write a description of class CustomerUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomerUI
{
    private CustomerController customercontroller;
    private CustomerContainer customercontainer;
    
    public CustomerUI(){
        customercontainer = CustomerContainer.getInstance();
    }
    
    public void start() {
        customerMenu();
    }
    
    private void customerMenu() {
       boolean exit = false;
       while(!exit) {
           int choice = writeOrderMenu();
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
    
     private int writeOrderMenu() {
        // creates a keyboard object to read input
        TextOptions menu = new TextOptions("\n ***** Kunde menu *****", "Tilbage"); 
        menu.addOption("Opret en profil");

        
        int choice = menu.prompt();

        return choice;
    }
    
    private void createCustomer() {
        String name = TextInput.inputString("Tilføj kundens navn: ");
        int phone = TextInput.inputNumber("Tilføj kundens telefon nummer: ");
        Customer customer = new Customer(name, phone);
        customercontainer.saveCustomer(customer);
        System.out.println("Kunde oprettet: " + name + " med telefonnummer: " + phone);
    }  

}
