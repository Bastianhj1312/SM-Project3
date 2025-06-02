package Containers;
import Models.*;
import java.util.ArrayList;

/**
 * Write a description of class ProductContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductContainer
{
    private ArrayList<Product> products;
    private static ProductContainer instance;
    private ArrayList<UniqueProductCopy> uniqueProductCopies;

    private ProductContainer(){
        products = new ArrayList<>();
        uniqueProductCopies = new ArrayList<>();
    }

    public static ProductContainer getInstance(){
        if(instance == null){
            instance = new ProductContainer();
        }
        return instance;
    }

    public void saveProduct(Product product){
        products.add(product);
    }

    public Product findProduct(int productNo){
        Product product = null;
        boolean found = false;
        int i = 0;
        while(!found && i < products.size()){
            Product p = products.get(i);
            if(p.getProductNo()==productNo){
                product = p;
                found = true;
            }
            else {
                i++;
            }
        }
        return product;
    }
    // Nye metoder til UniqueProductCopy:
    public void saveUniqueProductCopy(UniqueProductCopy copy) {
        uniqueProductCopies.add(copy);
    }

    public ArrayList<UniqueProductCopy> getAllUniqueProductCopies() {
        return uniqueProductCopies;
    }

    // Eller en metode til at finde én unik kopi ud fra produkt og serienummer:
    public UniqueProductCopy findUniqueProductCopy(UniqueProduct product, int serialNumber) {
        for (UniqueProductCopy copy : uniqueProductCopies) {
            if (copy.getProduct().equals(product) && copy.getSerialNumber() == serialNumber) {
                return copy;
            }
        }
        return null;
    }
}
