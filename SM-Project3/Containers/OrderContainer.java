package Containers;
import Models.*;
import java.util.ArrayList;

public class OrderContainer {
    // Singleton instance
    private static OrderContainer instance;

    // List of orders
    private ArrayList<Order> orders;

    // Private constructor
    private OrderContainer() {
        orders = new ArrayList<Order>();
    }

    // Public method to get the single instance
    public static OrderContainer getInstance() {
        if (instance == null) {
            instance = new OrderContainer();
        }
        return instance;
    }

    // Method to add an order
    public void saveOrder(Order order) {
        orders.add(order);
    }

    // Method to find an order by staff ID
    public Order findOrder(Employee employee) {
        Order order = null;
        boolean found = false;
        int i = 0;
        while(!found && i < orders.size()){
            Order c = orders.get(i);
            if(c.getEmployee()==employee){
                order = c;
                found = true;
            }
            else {
                i++;
            }
            
        }
        return order;
    }

    // Method to check delivered status
    //public boolean checkDelivered(boolean delivered) {
      //  for (Order order : orders) {
        //    if (order.isDelivered() == delivered) {
          //      return delivered;
            //    // Add more logic here if needed
            //}
        //} 
        //return delivered;
    }