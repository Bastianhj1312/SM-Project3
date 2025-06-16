package GUI;

import javax.swing.*;
import java.awt.*;
import Models.Order;
import Models.orderLine;
import Models.Product;

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

    private String buildReceipt(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee: ").append(order.getEmployee().getName())
          .append(" (ID: ").append(order.getEmployee().getStaffID()).append(")\n");
        sb.append("Customer: ").append(order.getCustomer().getName()).append("\n");
        sb.append("Order lines:\n");

        double total = 0.0;
        for (orderLine ol : order.getOrderLines()) {
            Product p = ol.getProduct();
            sb.append("- ").append(p.getProductName())
              .append(" (No: ").append(p.getProductNo()).append("), Qty: ")
              .append(ol.getQuantity()).append(", Unit: ")
              .append(p.getSellingPrice()).append(", Line: ")
              .append(ol.getLineTotal()).append("\n");
            if (ol.isUnique()) {
                sb.append("  Serial: ").append(ol.getUniqueProductCopy().getSerialNumber()).append("\n");
            }
            total += ol.getLineTotal();
        }
        sb.append("\nTotal: ").append(total).append(" kr");
        return sb.toString();
    }
}
