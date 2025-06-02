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

    // Eller en metode til at finde én unik kopi ud fra produkt og serienummer:
    public UniqueProductCopy findUniqueProductCopy(int productNo, int serialNumber) {
        int i = 0;
        UniqueProductCopy copyFound = null;

        while (i < uniqueProductCopies.size() && copyFound == null) {
            UniqueProductCopy copy = uniqueProductCopies.get(i);
            if (copy.getProduct().getProductNo() == productNo && copy.getSerialNumber() == serialNumber) {
                copyFound = copy;
            } else {
                i++;
            }
        }
        return copyFound;
    }
}
