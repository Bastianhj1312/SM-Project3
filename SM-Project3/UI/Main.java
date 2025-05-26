package UI;

import Containers.ProductContainer;
import Models.*;

public class Main {
    public static void main(String[] args) {
        ProductContainer container = ProductContainer.getInstance();

        Product p1 = new SimpleProduct(101, 5, 20.0);
        Product p2 = new UniqueProduct(202, 499.0);

        container.saveProduct(p1);
        container.saveProduct(p2);

        container.printAllProducts();
    }
}
