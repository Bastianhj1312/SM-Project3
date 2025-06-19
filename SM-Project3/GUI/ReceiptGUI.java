package GUI;

import javax.swing.*;
import java.awt.*;
import Models.Order;
import Models.orderLine;
import Models.Product;
import Models.UniqueProductCopy;
import Controllers.*;

public class ReceiptGUI extends JDialog {
    private static final long serialVersionUID = 1L;

    public ReceiptGUI(Order order) {
        setTitle("Receipt");
        setBounds(100, 100, 500, 400);
        setModal(true);
        getContentPane().setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText(buildReceipt(order));
        getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> dispose());
        buttonPane.add(okButton);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }

    private String getSerialNumbersForProduct(Product p, ProductController productcontroller) {
        StringBuilder serials = new StringBuilder();
        for (UniqueProductCopy copy : productcontroller.findAllUniqueProductCopies()) {
            if (copy.getProduct().equals(p)) {
                if (serials.length() > 0) serials.append(", ");
                serials.append(copy.getSerialNumber());
            }
        }
        return serials.length() > 0 ? " | Serials: " + serials : "";
    }

    private String buildReceipt(Order order) {
        ProductController productcontroller = new ProductController();
        String receipt = "Employee: " + order.getEmployee().getName() +
                         " (ID: " + order.getEmployee().getStaffID() + ")\n" +
                         "Customer: " + order.getCustomer().getName() + "\n" +
                         "Order lines:\n";

        double total = 0.0;
        for (orderLine ol : order.getOrderLines()) {
            Product p = ol.getProduct();
            receipt += "- " + p.getProductName() +
                       " (No: " + p.getProductNo() + "), Qty: " +
                       ol.getQuantity() + ", Unit: " +
                       p.getSellingPrice() + ", Line: " +
                       ol.getLineTotal();

            if (p.isUniqueProduct()) {
                receipt += getSerialNumbersForProduct(p, productcontroller);
            }
            receipt += "\n";
            total += ol.getLineTotal();
        }
        receipt += "\nTotal: " + total + " kr";
        return receipt;
    }
 

}
