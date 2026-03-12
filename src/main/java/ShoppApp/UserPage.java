package ShoppApp;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import ShoppApp.controller.DataStore;

public class UserPage extends JFrame implements ActionListener {

    Container con;

    JLabel lblTitle, lblAdmin;
    JTextField txtSearch;
    JButton btnAdd, btnEdit, btnDelete, btnClear;
    JTable table;

    DefaultTableModel model;
    TableRowSorter<DefaultTableModel> sorter;

    String username;
    String password;

    public UserPage() {
        setTitle("Products");
        setBounds(0, 0, 1800, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        con = getContentPane();
        con.setLayout(null);

        NavMenu nav = new NavMenu(this);
        setJMenuBar(nav.menuBar);

        // Logo
        ImageIcon icon = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/Logo.png")
        );
        Image imgIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        setIconImage(imgIcon);

        ImageIcon logo = new ImageIcon(getClass().getResource("/ShoppApp/assets/Logo.png"));
        Image img = logo.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);

        JLabel lblLogo = new JLabel(new ImageIcon(img));
        lblLogo.setBounds(670, 50, 90, 70);
        con.add(lblLogo);

        // Admin Title
        lblAdmin = new JLabel("Shop App Admin");
        lblAdmin.setFont(new Font("Roboto", Font.BOLD, 40));
        lblAdmin.setBounds(760, 60, 400, 50);
        con.add(lblAdmin);

        // Products Title
        lblTitle = new JLabel("Users");
        lblTitle.setFont(new Font("Roboto", Font.BOLD, 30));
        lblTitle.setBounds(190, 150, 200, 30);
        con.add(lblTitle);

        // Search Field
        JLabel lblSearch = new JLabel("Search User:");
        lblSearch.setBounds(190, 205, 120, 30);
        con.add(lblSearch);

        txtSearch = new JTextField();
        txtSearch.setBounds(290, 205, 250, 30);
        con.add(txtSearch);

        // Buttons
        btnAdd = new JButton("Add User");
        btnAdd.setBounds(1080, 200, 120, 35);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        con.add(btnAdd);

        btnEdit = new JButton("Edit User");
        btnEdit.setBounds(1210, 200, 120, 35);
        btnEdit.setBackground(Color.BLACK);
        btnEdit.setForeground(Color.WHITE);
        con.add(btnEdit);

        btnDelete = new JButton("Delete User");
        btnDelete.setBounds(1340, 200, 120, 35);
        btnDelete.setBackground(Color.RED);
        btnDelete.setForeground(Color.WHITE);
        con.add(btnDelete);

        btnClear = new JButton("Clear");
        btnClear.setBounds(1470, 200, 120, 35);
        btnClear.setBackground(Color.GRAY);
        btnClear.setForeground(Color.WHITE);
        con.add(btnClear);

        // Table
        model = DataStore.userModel;

        table = new JTable(model);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(190, 250, 1400, 500);
        con.add(scroll);

        btnAdd.addActionListener(this);
        btnEdit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        txtSearch.addActionListener(this);

        txtSearch.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = txtSearch.getText();
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        );
    }

    public void addUser() {
            username = JOptionPane.showInputDialog(
                null,
                "Enter Username:",
                "Customer Register",
                JOptionPane.PLAIN_MESSAGE
            );

            if (username == null || username.trim().isEmpty()) {
                return;
            }

            password = JOptionPane.showInputDialog(
                null,
                "Enter Password:",
                "Customer Register",
                JOptionPane.PLAIN_MESSAGE
            );

            if (password == null || password.trim().isEmpty()) {
                return;
            }

            int id = model.getRowCount() + 1;
            model.addRow(new Object[] { id, username, password });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAdd) {
            addUser();
        }
        
        if (e.getSource() == btnEdit) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                return;
            }

            String productName = JOptionPane.showInputDialog(
                null,
                "Enter Product Name:",
                "Product Name",
                JOptionPane.PLAIN_MESSAGE
            );

            if (productName == null || productName.trim().isEmpty()) {
                return;
            }

            String price = JOptionPane.showInputDialog(
                null,
                "Enter Price:",
                "Price",
                JOptionPane.PLAIN_MESSAGE
            );

            if (price == null || price.trim().isEmpty()) {
                return;
            }

            String stock = JOptionPane.showInputDialog(
                null,
                "Enter Stock:",
                "Stock",
                JOptionPane.PLAIN_MESSAGE
            );

            if (stock == null || stock.trim().isEmpty()) {
                return;
            }

            model.setValueAt(productName, selectedRow, 1);
            model.setValueAt(price, selectedRow, 2);
            model.setValueAt(stock, selectedRow, 3);
        } else if (e.getSource() == btnDelete) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                return;
            }

            model.removeRow(selectedRow);
        } else if (e.getSource() == btnClear) {
            txtSearch.setText("");
            sorter.setRowFilter(null);
            model.setRowCount(0);
        }
    }
}
