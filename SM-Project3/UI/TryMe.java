package UI;

import Containers.*;
import Models.*;

public class TryMe {
    ProductContainer productContainer = ProductContainer.getInstance();
    CustomerContainer customerContainer = CustomerContainer.getInstance();

   public void start() {
    // lav simple products
    SimpleProduct product1 = new SimpleProduct(101, 50, "USB Cable", "Logitech", "X200",
            20.0, "Supplier1", "SKU101", "A1", 54);
    SimpleProduct product2 = new SimpleProduct(102, 30, "Wireless Mouse", "Logitech", "M330",
            25.0, "Supplier1", "SKU102", "B2", 54);

    // lav unique
    UniqueProduct uniqueProduct1 = new UniqueProduct(201, 1399.0, "Gaming Laptop", "Asus", "ROG Zephyrus",
            1499.0, "Supplier2", "SKU201");
    UniqueProduct uniqueProduct2 = new UniqueProduct(202, 279.0, "3D Printer", "Creality", "Ender 3",
            299.0, "Supplier3", "SKU202");

    // lav serialnummer copies
    UniqueProductCopy copy1 = new UniqueProductCopy(uniqueProduct1, 123456);
    UniqueProductCopy copy2 = new UniqueProductCopy(uniqueProduct2, 789012);

    // gem produkter
    productContainer.saveProduct(product1);
    productContainer.saveProduct(product2);
    productContainer.saveProduct(uniqueProduct1);
    productContainer.saveProduct(uniqueProduct2);

    // ❗ gem unikke kopier
    productContainer.saveUniqueProductCopy(copy1);
    productContainer.saveUniqueProductCopy(copy2);

    // lav kunder
    PrivateCustomer customer = new PrivateCustomer("Peter", 1234);
    BusinessCustomer bcustomer = new BusinessCustomer("Søren", 12345678);
    customerContainer.savePrivateCustomer(customer);
    customerContainer.saveBusinessCustomer(bcustomer);
}

}
