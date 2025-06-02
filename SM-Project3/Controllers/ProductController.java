package Controllers;
import Models.*;
import Containers.*;
import java.util.ArrayList;

/**
 * Write a description of class ProductController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductController {
    ProductContainer productcontainer;
    Product product;

    public ProductController(){
        productcontainer = ProductContainer.getInstance();
    }

    public Product findProduct(int productNo){
        return productcontainer.findProduct(productNo);
    }

    public UniqueProductCopy findUniqueProductCopy(UniqueProduct product, int serialNumber) {
        for (UniqueProductCopy copy : productcontainer.getAllUniqueProductCopies()) {
            if (copy.getProduct().equals(product) && copy.getSerialNumber() == serialNumber) {
                return copy;
            }
        }
        return null; // Ikke fundet
    }

    public ArrayList<UniqueProductCopy> getAllUniqueProductCopies() {
        return productcontainer.getAllUniqueProductCopies();
    }
}
