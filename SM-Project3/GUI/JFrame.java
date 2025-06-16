
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
        gbl_panel_1.rowHeights = new int[]{23, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
                btnNewButton = new JButton("Lav ordre");
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		// Inside actionPerformed
                		try {
                		    String staffId = textField.getText().trim();
                		    String phoneNumber = textField_1.getText().trim();
                		    String mængde = Mængde.getText().trim();
                		    String productiD = list.getSelectedValue();

                		    if (staffId.isEmpty() || phoneNumber.isEmpty() || mængde.isEmpty() || productiD == null) {
                		        // Show error message (e.g., JOptionPane)
                		        System.out.println("Please fill all fields and select a product.");
                		        return;
                		    }

                		    int staffID = Integer.parseInt(staffId);
                		    int phonenumber = Integer.parseInt(phoneNumber);
                		    int quantity = Integer.parseInt(mængde);

                		    boolean isBusinessCustomer = tglbtnNewToggleButton.isSelected();
                		    customercontroller.findCustomer(phonenumber);
                		    customercontroller.findEmployee(staffID);

                		    int productNo = Integer.parseInt(productiD.split(" - ")[0]);
                		    Product selectedProduct = productcontroller.findProduct(productNo);
                		    if (selectedProduct != null && currentOrder != null) {
                		        currentOrder.addOrderLine(selectedProduct, quantity);
                		    }
                		    System.out.println("Order created with Staff ID: " + staffID + ", Phone Number: " + phonenumber + ", Is Business Customer: " + isBusinessCustomer);
                            System.out.println("Product selected: " + selectedProduct.getProductName() + ", Quantity: " + quantity);
                		    textField.setText("");
                		    textField_1.setText("");
                		    Mængde.setText("");
                		    list.clearSelection();
                		} catch (NumberFormatException ex) {
                		    System.out.println("Please enter valid numbers for Staff ID, Phone Number, and Quantity.");
                		}

                	}
                });
                
                GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
                gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
                gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
                gbc_btnNewButton.gridx = 0;
                gbc_btnNewButton.gridy = 0;
                panel_1.add(btnNewButton, gbc_btnNewButton);
                
                btnNewButton_1 = new JButton("Print kvittering");
                GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
                gbc_btnNewButton_1.gridx = 0;
                gbc_btnNewButton_1.gridy = 1;
                panel_1.add(btnNewButton_1, gbc_btnNewButton_1);

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_2.add(scrollPane, BorderLayout.CENTER);
        init();
        scrollPane.setViewportView(list);
        
        
    }
    private void init() {
        tryMe.start();
        ProductContainer productContainer = ProductContainer.getInstance();

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (Product p : productContainer.getAllProducts()) {
            String display = p.getProductNo() + " - " + p.getProductName();
            // Check if product is UniqueProduct
            if (p instanceof Models.UniqueProduct) {
                // Show all serial numbers for this unique product
                for (Models.UniqueProductCopy copy : productContainer.getAllUniqueProductCopies()) {
                    if (copy.getProduct().equals(p)) {
                        display += " | Serial: " + copy.getSerialNumber();
                    }
                }
            }
            listModel.addElement(display);
        }
    }
}
    

