package UI;
import Containers.*;
import Controllers.*;
import Models.*;

/**
 * Write a description of class TryMe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TryMe
{
    ProductContainer productcontainer = ProductContainer.getInstance();
    
    public static void main(String[] args){
        SimpleProduct product1 = new SimpleProduct(101, 50, "USB Cable", "Logitech", "X200", 20.0, "Supplier1", "SKU101", "a");
        SimpleProduct product2 = new SimpleProduct(102, 30, "Wireless Mouse", "Logitech", "M330", 25.0, "Supplier1", "SKU102", "a");
    }
}
