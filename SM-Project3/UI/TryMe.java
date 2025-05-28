package UI;

import Containers.*;
import Controllers.*;
import Models.*;

public class TryMe {
    ProductContainer productcontainer = ProductContainer.getInstance();

    public void start() {
        SimpleProduct product1 = new SimpleProduct(101, 50, "USB Cable", "Logitech", "X200", 20.0, "Supplier1", "SKU101", "a");
        SimpleProduct product2 = new SimpleProduct(102, 30, "Wireless Mouse", "Logitech", "M330", 25.0, "Supplier1", "SKU102", "a");
    }
}
