package Controllers;
import Models.*;
import Containers.*;

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
    
}
