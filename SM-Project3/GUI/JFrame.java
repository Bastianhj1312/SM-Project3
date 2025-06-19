
package GUI;

import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import Containers.ProductContainer;
import Controllers.CustomerController;
import Controllers.OrderController;
import Controllers.ProductController;
import Models.Employee;
import Models.Order;
import Models.PrivateCustomer;
import Models.Product;
import java.util.List;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private UI.TryMe tryMe = new UI.TryMe();
    private JList<String> list; // JList for products
    private DefaultListModel<String> listModel; // Model for the JList
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private CustomerController customercontroller = new CustomerController();
    private ProductController productcontroller = new ProductController();
    private OrderController orderController = new OrderController();
    private JTextField Mængde;
    private Order currentOrder;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 715, 474);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JLabel lblNewLabel = new JLabel("Indtast staffID");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        panel.add(lblNewLabel, gbc_lblNewLabel);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Indtast telefonnummer/Eller cvr nummer ved forretningskunde");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 1;
        panel.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Privatkunde eller forretningskunde");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 2;
        panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

        JToggleButton tglbtnNewToggleButton = new JToggleButton("Tryk for forretningskunde");
        GridBagConstraints gbc_tglbtnNewToggleButton = new GridBagConstraints();
        gbc_tglbtnNewToggleButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_tglbtnNewToggleButton.insets = new Insets(0, 0, 5, 0);
        gbc_tglbtnNewToggleButton.gridx = 1;
        gbc_tglbtnNewToggleButton.gridy = 2;
        panel.add(tglbtnNewToggleButton, gbc_tglbtnNewToggleButton);

        JLabel lblNewLabel_3 = new JLabel("Indtast mængde");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 3;
        panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

        Mængde = new JTextField();
        GridBagConstraints gbc_mængde = new GridBagConstraints();
        gbc_mængde.fill = GridBagConstraints.HORIZONTAL;
        gbc_mængde.gridx = 1;
        gbc_mængde.gridy = 3;
        panel.add(Mængde, gbc_mængde);
        Mængde.setColumns(10);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.EAST);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{79, 0};
        gbl_panel_1.rowHeights = new int[]{23, 0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);

        btnNewButton = new JButton("Tilføj produkt til ordre");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	addProductToOrder();
            }
        });

        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 0;
        panel_1.add(btnNewButton, gbc_btnNewButton);

        btnNewButton_1 = new JButton("Print kvittering");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Order order = orderController.getOrder();
                if (order != null) {
                    ReceiptGUI receipt = new ReceiptGUI(order);
                    receipt.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No order to print receipt for.");
                }
            }
        });

        JButton btnNewButton_2 = new JButton("Lav ordre");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String staffId = textField.getText();
                String phoneNumber = textField_1.getText();
                boolean isBusinessCustomer = tglbtnNewToggleButton.isSelected();

                if (isBusinessCustomer) {
                    int cvr = Integer.parseInt(phoneNumber);
                    orderController.addBusinessCustomerToOrder(cvr);
                    currentOrder = orderController.getOrder();
                    if (currentOrder == null) {
                        JOptionPane.showMessageDialog(null, "Failed to create order. Please check the input.");
                        return;
                    }
                    int staffID = Integer.parseInt(staffId);
                    orderController.addEmployeetoOrder(staffID);
                } else if (phoneNumber.isEmpty() || staffId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields.");
                } else if (!phoneNumber.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Phone number must be numeric.");
                } else if (!staffId.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Staff ID must be numeric.");
                } else {
                    int phonenumber = Integer.parseInt(phoneNumber);
                    int staffID = Integer.parseInt(staffId);
                    orderController.addCustomertoOrder(phonenumber);
                    orderController.addEmployeetoOrder(staffID);
                    currentOrder = orderController.getOrder();
                }
            }
        });

        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_2.gridx = 0;
        gbc_btnNewButton_2.gridy = 1;
        panel_1.add(btnNewButton_2, gbc_btnNewButton_2);

        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_1.gridx = 0;
        gbc_btnNewButton_1.gridy = 2;
        panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
        
        JButton btnNewButton_3 = new JButton("Afslut Ordre");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentOrder == null) {
                    JOptionPane.showMessageDialog(null, "No order to finish.");
                    return;
                }
                // Example: Save or finalize the order
                orderController.finishOrder(currentOrder);

                JOptionPane.showMessageDialog(null, "Order finished successfully!");

                // Reset for new order
                currentOrder = null;
                textField.setText("");
                textField_1.setText("");
                Mængde.setText("");
                list.clearSelection();
            }
        });

        GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
        gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_3.gridx = 0;
        gbc_btnNewButton_3.gridy = 3;
        panel_1.add(btnNewButton_3, gbc_btnNewButton_3);

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane();
        panel_2.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(list);
        init();
        findAllProducts();
        
    }

    private void init() {
        tryMe.start();
       
        
    }
    private void findAllProducts() {
    	for (Product p : productcontroller.findAll()) {
            String display = p.getProductNo() + " - " + p.getProductName();
            // Check if product is UniqueProduct
            if (p.isUniqueProduct()) {
                // Show all serial numbers for this unique product
                for (Models.UniqueProductCopy copy : productcontroller.findAllUniqueProductCopies()) {
                    if (copy.getProduct().equals(p)) {
                        display += " | Serial: " + copy.getSerialNumber();
                    }
                }
            }
            listModel.addElement(display);
        }
    }
    private void addProductToOrder() {
    	 try {
             String mængde = Mængde.getText();
             String productiD = list.getSelectedValue();

             if (mængde.isEmpty() || productiD == null) {
                 JOptionPane.showMessageDialog(null, "Please fill all fields and select a product.");
                 return;
             }

             int quantity = Integer.parseInt(mængde);
             int productNo = Integer.parseInt(productiD.split(" - ")[0]);
             if (currentOrder == null) {
                 JOptionPane.showMessageDialog(null, "Please create an order first.");
                 return;
             }
             orderController.addProductToOrder(productNo, quantity);
         } catch (NumberFormatException ex) {
             JOptionPane.showMessageDialog(null, "Please enter a valid number for Quantity.");
         }
    }
}
