package ShoppApp.controller;

import javax.swing.table.DefaultTableModel;

public class DataStore {

    // Shared Product Table
    public static DefaultTableModel productModel = new DefaultTableModel(
        new String[] { "Product ID", "Product Name", "Price", "Stock" },
        0
    );

    // Shared Transaction Table
    public static DefaultTableModel transactionModel = new DefaultTableModel(
        new String[] { "Transaction ID", "Product", "Qty", "Total" },
        0
    );

    public static DefaultTableModel userModel = new DefaultTableModel(
        new String[] { "user_ID", "username", "password" },
        0
    );

    public static void setSoldList() {}

    //total amount
    public static double totalAmount = 0;

    public static double getTotalAmount() {
        return totalAmount;
    }

    public static void setTotalAmount(double total) {
        totalAmount = total;
    }

    //sample products
    static {
        productModel.addRow(new Object[] { "1", "Keyboard", "500", "10" });
        productModel.addRow(new Object[] { "2", "Mouse", "200", "25" });
        productModel.addRow(new Object[] { "3", "Monitor", "8000", "5" });
    }

    //default admin account
    static {
        userModel.addRow(new Object[] { "1", "customer", "customer" });
    }
}
