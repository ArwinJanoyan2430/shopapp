package ShoppApp;

import ShoppApp.controller.DataStore;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class CustomerShoppingPage extends JFrame implements ActionListener {

    Container con;
    DefaultListModel<String> productModel = new DefaultListModel<>();
    DefaultListModel<String> cartModel = new DefaultListModel<>();
    JList<String> productList = new JList<>(productModel);
    JList<String> cartList = new JList<>(cartModel);
    JTextField totalField = new JTextField(10);
    JLabel lblTitle, lblProducts, lbltotal, lblNote, cartLabel;
    JButton btnAdd, btnCheckout, btnRemove, btnClear, btnExit, btnLogout;
    DefaultTableModel model;
    JScrollPane cartPane, productPane;
    
    int totalAmount = 0;
    DataStore ds = new DataStore();
    
    public CustomerShoppingPage() {
        setTitle("Shop App - Customer Page");
        setSize(1800, 900);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.WHITE);

        loadProducts();

        ImageIcon icon = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/Logo.png")
        );
        Image imgIcon = icon
            .getImage()
            .getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        setIconImage(imgIcon);

        ImageIcon logo = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/Logo.png")
        );
        Image img = logo
            .getImage()
            .getScaledInstance(100, 90, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));
        lblLogo.setBounds(670, 40, 90, 70);
        con.add(lblLogo);

        // HEADER TITLE BAR SOMETHING NGA NAAY DESIGN UG FONTS PAKAK
        lblTitle = new JLabel("Shop App", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 60));
        lblTitle.setBounds(0, 40, 1800, 80);
        add(lblTitle);

        // MGA BUTTONS SA LEFT NGA NAAY DESIGN UG FONTS PAKAK
        lblProducts = new JLabel("Products");
        lblProducts.setFont(new Font("Arial", Font.BOLD, 18));
        lblProducts.setBounds(100, 180, 150, 40);
        add(lblProducts);

        btnAdd = new JButton("Add to Cart");
        btnAdd.setBackground(new Color(33, 33, 33));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
        btnAdd.setBounds(580, 180, 180, 40);
        add(btnAdd);

        productPane = new JScrollPane(productList);
        productList.setFont(new Font("Arial", Font.PLAIN, 18));
        productPane.setBounds(100, 240, 660, 550);
        add(productPane);

        // MGA BUTTONS SA RIGHT NGA NAAY DESIGN UG FONTS HAHAHAHAHA LAMI KAAYO
        cartLabel = new JLabel("My Cart");
        cartLabel.setFont(new Font("Arial", Font.BOLD, 18));
        cartLabel.setBounds(850, 180, 100, 40);
        add(cartLabel);

        btnRemove = new JButton("Remove Item");
        btnRemove.setBackground(new Color(200, 0, 0));
        btnRemove.setForeground(Color.WHITE);
        btnRemove.setBounds(1180, 180, 160, 40);
        add(btnRemove);

        btnClear = new JButton("Clear Cart");
        btnClear.setBackground(new Color(100, 149, 237));
        btnClear.setForeground(Color.WHITE);
        btnClear.setBounds(1350, 180, 160, 40);
        add(btnClear);

        cartPane = new JScrollPane(cartList);
        cartList.setFont(new Font("Roboto", Font.PLAIN, 18));
        cartPane.setBounds(850, 240, 660, 550);
        add(cartPane);

        // --- TOTAL & CHECKOUT ---
        lbltotal = new JLabel("Total");
        lbltotal.setFont(new Font("Roboto", Font.BOLD, 22));
        lbltotal.setBounds(1550, 240, 100, 40);
        add(lbltotal);

        totalField.setBounds(1550, 290, 180, 45);
        totalField.setFont(new Font("Roboto", Font.BOLD, 20));
        totalField.setText("₱ 0");
        totalField.setEditable(false);
        add(totalField);

        btnCheckout = new JButton("Checkout");
        btnCheckout.setBackground(new Color(106, 45, 214));
        btnCheckout.setForeground(Color.WHITE);
        btnCheckout.setFont(new Font("Roboto", Font.BOLD, 18));
        btnCheckout.setBounds(1550, 350, 180, 50);
        add(btnCheckout);

        btnExit = new JButton("Exit");
        btnExit.setBackground(Color.RED);
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Roboto", Font.BOLD, 18));
        btnExit.setBounds(1550, 680, 180, 50);
        add(btnExit);

        btnLogout = new JButton("Logout");
        btnLogout.setBackground(Color.BLUE);
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFont(new Font("Roboto", Font.BOLD, 18));
        btnLogout.setBounds(1550, 740, 180, 50);
        add(btnLogout);
        
        lblNote = new JLabel("Note: The (X) button is disabled. please use the button to exit.");
        lblNote.setFont(new Font("Roboto", Font.BOLD, 12));
        lblNote.setForeground(Color.DARK_GRAY);
        lblNote.setBounds(10, 840, 400, 12);
        add(lblNote);
        
        btnClear.addActionListener(this);
        btnCheckout.addActionListener(this);
        btnRemove.addActionListener(this);
        btnAdd.addActionListener(this);
        btnExit.addActionListener(this);
        btnLogout.addActionListener(this);
    }

    private void loadProducts() {
        productModel.clear(); // Clear previous data

        for (int i = 0; i < DataStore.productModel.getRowCount(); i++) {
            String name = DataStore.productModel.getValueAt(i, 1).toString();
            String price = DataStore.productModel.getValueAt(i, 2).toString();

            productModel.addElement(name + " - ₱" + price);
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String selected = productList.getSelectedValue();
            if (selected != null) {

                // Ask for quantity
                String qtyStr = JOptionPane.showInputDialog(
                    this,
                    "Enter quantity for this product:",
                    "Quantity",
                    JOptionPane.PLAIN_MESSAGE
                );

                if (qtyStr == null || qtyStr.trim().isEmpty()) {
                    return; // user canceled
                }

                int qty = 0;

                try {
                    qty = Integer.parseInt(qtyStr);
                    if (qty <= 0) {
                        JOptionPane.showMessageDialog(this, "Quantity must be at least 1.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid quantity entered.");
                    return;
                }

                // para "product - price" to {"product","price"}
                String[] parts = selected.split(" - ₱");
                String productName = parts[0];
                String priceStr = parts[1];

                // Add product with quantity to cart
                String cartItem = productName + " - " + priceStr + " - " + qty;
                cartModel.addElement(cartItem);
                updateTotal(cartItem, true);

                JOptionPane.showMessageDialog(this, qty + " item(s) added to the cart.");
            }
        }


        if (e.getSource() == btnClear) {
            cartModel.clear();
            totalAmount = 0;
            totalField.setText("₱ 0");
        }

        if (e.getSource() == btnRemove) {
            String selected = cartList.getSelectedValue();
            if (selected != null) {
                cartModel.removeElement(selected);
                updateTotal(selected, false);
            }
        }

        if (e.getSource() == btnCheckout) {
             
            if (totalField.getText().equals("₱ 0")) {
                JOptionPane.showMessageDialog(
                    this,
                    "Cart is empty. Cannot checkout."
                );
                return;
            } else if (!totalField.getText().equals("₱ 0")) {
                String address = JOptionPane.showInputDialog("Enter address: ");
                if (address == null || address.trim().isEmpty()) {
                    return;
                }

                String phoneNum = JOptionPane.showInputDialog(
                    "Enter phone no.: 63+ "
                );
                if (phoneNum == null || phoneNum.trim().isEmpty()) {
                    return;
                }    
                
                //to show item checked out in the reports page
                model = DataStore.transactionModel;
                // Checkout loop
                for (int i = 0; i < cartModel.getSize(); i++) {
                    String item = cartModel.getElementAt(i);

                    // Split "ProductName - Price - Qty"
                    String[] parts = item.split(" - "); // mahimo syang {"product", "price", "qty"}
                    String product = parts[0].trim(); //to get the product and trim to remove the spaces
                    int price = Integer.parseInt(parts[1].trim()); //get the price
                    int qty = Integer.parseInt(parts[2].trim()); // quantity
                    int total = price * qty;
                    int transactionId = model.getRowCount() + 1; // add row to the table

                    model.addRow(new Object[] { transactionId, product, qty, price ,total}); //send to the table
                }
                JOptionPane.showMessageDialog(this, "Checkout successful!");
                
                totalAmount = 0;
                cartModel.clear();
                totalField.setText("₱ 0");
            }        
        }

        if (e.getSource() == btnExit) {
            this.dispose();
        }

        if (e.getSource() == btnLogout) {
            LoginPage lp = new LoginPage();

            JPanel bg = new JPanel();
            bg.setLayout(null);
            bg.setBounds(0, 130, 1800, 580);
            bg.setBackground(Color.BLACK);
            lp.add(bg);

            JPanel bgPanel = new JPanel();
            bgPanel.setLayout(null);
            bgPanel.setBounds(1000, 90, 400, 400);
            bgPanel.setBackground(Color.WHITE);
            bg.add(bgPanel);

            lp.setVisible(true);
            this.dispose();
        }
    }

    private void updateTotal(String item, boolean adding) {

    //"ProductName - Price - Qty"
        String[] parts = item.split(" - ");
        if (parts.length < 3) {
            return; // safety check
        }

        String priceStr = parts[1];  //price part
        String qtyStr = parts[2];    //quantity part

        int price = Integer.parseInt(priceStr);
        int qty = Integer.parseInt(qtyStr);

        int totalChange = price * qty;

        if (adding) {
            totalAmount += totalChange;
        } else {
            totalAmount -= totalChange;
        }

        ds.setTotalAmount(totalAmount);
        totalField.setText("₱ " + totalAmount);
    }
}
