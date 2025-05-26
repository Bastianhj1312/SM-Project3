package UI;

import Containers.ProductContainer;
import Models.*;

public class Main {
    public static void main(String[] args) {
        ProductContainer container = ProductContainer.getInstance();

        // Create a simple product
        SimpleProduct p1 = new SimpleProduct(
            101, 5, "USB Cable", "Logitech", "X200", 20.0, "SUP001", "SKU101"
        );

        // Create a unique product
        UniqueProduct p2 = new UniqueProduct(
            202, "SN-0001", 499.0
        );

        // Save products in container
        container.saveProduct(p1);
        container.saveProduct(p2);

        // Print all products
        container.printAllProducts();
    }
}
