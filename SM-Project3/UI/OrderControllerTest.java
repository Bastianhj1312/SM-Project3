package UI; // eller fx package test eller ingen package, afhængigt af dit projekt setup

import Controllers.OrderController;
import Controllers.CustomerController;
import Models.*;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderControllerTest {

    private OrderController orderController;
    private CustomerController customerController;

    @Before
    public void setup() {
        customerController = new CustomerController();

        customerController.saveCustomer(new PrivateCustomer("Peter", 1234));
        customerController.saveBusinessCustomer(new BusinessCustomer("Firma X", 56789));

        orderController = new OrderController();
    }

    @Test
    public void testAddPrivateCustomerToOrder() {
        int phone = 1234;
        orderController.addCustomertoOrder(phone);

        Customer c = orderController.getOrder().getCustomer();
        assertNotNull(c);

        // Tjek klassens navn
        assertEquals("PrivateCustomer", c.getClass().getSimpleName());
        assertEquals("Peter", c.getName());
    }

    @Test
    public void testAddBusinessCustomerToOrder() {
        int cvr = 56789;
        orderController.addBusinessCustomerToOrder(cvr);

        Customer c = orderController.getOrder().getCustomer();
        assertNotNull(c);

        // Tjek klassens navn
        assertEquals("BusinessCustomer", c.getClass().getSimpleName());
        assertEquals("Firma X", c.getName());
    }
    @Test
    public void testSimpleProductCreation() {
        SimpleProduct sp = new SimpleProduct(101, 50, "USB Cable", "Logitech", "X200",
                20.0, "Supplier1", "SKU101", "A1", 54);

        assertEquals(101, sp.getProductNo());
        assertEquals("USB Cable", sp.getProductName());
        assertEquals("Logitech", sp.getManufacturer());
        assertEquals(20.0, sp.getRecommendedRetailPrice(), 0.001);
        assertFalse(sp.isUniqueProduct());
    }

    @Test
    public void testUniqueProductCreation() {
        UniqueProduct up = new UniqueProduct(201, 1399.0, "Gaming Laptop", "Asus", "ROG Zephyrus",
                1499.0, "Supplier2", "SKU201");

        assertEquals(201, up.getProductNo());
        assertEquals("Gaming Laptop", up.getProductName());
        assertEquals("Asus", up.getManufacturer());
        assertEquals(1399.0, up.getSellingPrice(), 0.001);
        assertTrue(up.isUniqueProduct());
    }

    @Test
    public void testUniqueProductCopy() {
        UniqueProduct up = new UniqueProduct(201, 1399.0, "Gaming Laptop", "Asus", "ROG Zephyrus",
                1499.0, "Supplier2", "SKU201");
        UniqueProductCopy upc = new UniqueProductCopy(up, 123456);
        orderLine ol = new orderLine(upc);
        assertTrue(ol.isUnique());
        assertEquals(123456, upc.getSerialNumber());
    }
}
