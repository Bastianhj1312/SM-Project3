package Controllers;
import Containers.*;
import Models.*;

public class OrderController {
    CustomerController customercontroller;
    ProductController productcontroller;
    Order order;
    

    public OrderController() {
        customercontroller = new CustomerController();
        productcontroller = new ProductController();
    }

    public void addUniqueProductToOrder(UniqueProduct product, int serialNumber) {
        UniqueProductCopy copy = new UniqueProductCopy(product, serialNumber);
        order.getOrderLines().add(new orderLine(copy));  // Only 1 quantity
    }

    public Customer addCustomertoOrder(int phone) {
        PrivateCustomer customer = customercontroller.findCustomer(phone);  // findPrivateCustomer, som returnerer PrivateCustomer
        if (customer != null) {
            order = new Order(customer);  // order skal kunne tage Customer (eller PrivateCustomer)
        } else {
            System.out.println("Privatkunde ikke fundet.");
        }
        return customer;
    }

    public BusinessCustomer addBusinessCustomerToOrder(int cvr) {
        BusinessCustomer customer = customercontroller.findBusinessCustomer(cvr);
        if (customer != null) {
            order = new Order(customer);
        } else {
            System.out.println("Forretning ikke fundet.");
        }
        return customer;
    }

    public Order addProductToOrder(int productNo, int quantity) {
        Product product = productcontroller.findProduct(productNo); 

        if(product == null){
            System.out.println("Product is null");
        }else{
            order.addOrderLine(product, quantity);
        }  
        return order;
    }

    public Order getOrder() {
        return order;
    }
}
