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

    public void addUniqueProductToOrder(UniqueProductCopy copy) {
        order.getOrderLines().add(new orderLine(copy));
    }

    public Customer addCustomertoOrder(int phone) {
        PrivateCustomer customer = customercontroller.findCustomer(phone);
        if (customer != null) {
            order = new Order(customer);
        }
        return customer;
    }

    public Employee addEmployeetoOrder(int staffID) {
        Employee employee = customercontroller.findEmployee(staffID);
        if (employee != null && order != null) {
            order.setEmployee(employee); 
        }
        return employee;
    }

    public BusinessCustomer addBusinessCustomerToOrder(int cvr) {
        BusinessCustomer customer = customercontroller.findBusinessCustomer(cvr);
        if (customer != null) {
            order = new Order(customer);
        }
        return customer;
    }

    public Order addProductToOrder(int productNo, int quantity) {
        Product product = productcontroller.findProduct(productNo); 

        if(product == null){

        }else{
            order.addOrderLine(product, quantity);
        }  
        return order;
    }

    public Order getOrder() {
        return order;
    }

	public void finishOrder(Order currentOrder) {
				if (currentOrder != null) {
			OrderContainer.getInstance().saveOrder(currentOrder);
			order = null; // Reset the order after finishing
		} else {
			System.out.println("Ingen ordre at afslutte.");
		}
		
	}
}
