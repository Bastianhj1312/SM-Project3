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

    private ProductContainer(){
        products = new ArrayList<>();
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
            if(product.getProductNo()==productNo){
                product = p;
                found = true;
            }
            else {
                i++;
            }
        }
        return product;
    }

    public void printAllProducts() {
        for (Product p : products) {
            System.out.println("Product No: " + p.getProductNo());
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("Description: " + p.getDescription());
            System.out.println("Category: " + p.getCategory());
            System.out.println("Selling Price: " + p.getSellingPrice());
            System.out.println("Cost Price: " + p.getCostPrice());
            System.out.println("Total Price: " + p.getPrice());

            if (p instanceof SimpleProduct) {
                SimpleProduct sp = (SimpleProduct) p;
                System.out.println("Product Name: " + sp.getProductName());
                System.out.println("Manufacturer: " + sp.getManufacturer());
                System.out.println("Model: " + sp.getModel());
                System.out.println("Recommended Retail Price: " + sp.getRecommendedRetailPrice());
                System.out.println("Supplier ID: " + sp.getSupplierId());
                System.out.println("SKU: " + sp.getSku());
            } else if (p instanceof UniqueProduct) {
                UniqueProduct up = (UniqueProduct) p;
                System.out.println("Serial Number: " + up.getSerialNumber());
            }

            System.out.println("-----");
        }
    }

}
