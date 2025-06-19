package Controllers;
import Models.*;
import Containers.*;
import java.util.ArrayList;
import java.util.List;

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

    public UniqueProductCopy findUniqueProductCopy(int productNo, int serialNumber) {
        return productcontainer.findUniqueProductCopy(productNo, serialNumber);
    }
    public List<Product> findAll() {
		return productcontainer.getInstance().findAll();
	}
    public List<UniqueProductCopy> findAllUniqueProductCopies() {
		return productcontainer.findAllUniqueProductCopies();
	}
}
