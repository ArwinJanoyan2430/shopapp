package ShoppApp;

import ShoppApp.controller.DataStore;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ReportsPage extends JFrame {

    JLabel lblTitle, lblSales, lblTotal, lblNote;
    JTextField txtTotal;
    JTable tblReports;
    DefaultTableModel model;
    Container con;

    public ReportsPage() {
        con = getContentPane();
        setLayout(null);
        setVisible(true);
        setTitle("Reports Page");
        setBounds(0, 0, 1800, 900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        NavMenu nav = new NavMenu(this);
        setJMenuBar(nav.menuBar);

        ImageIcon icon = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/Logo.png")
        );
        Image imgIcon = icon
            .getImage()
            .getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        setIconImage(imgIcon);

        //  TITLE
        lblTitle = new JLabel("Shop App Admin");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        con.add(lblTitle);
        lblTitle.setBounds(760, 60, 400, 50);

        // SALES REPORT LABEL
        lblSales = new JLabel("Sales Report");
        lblSales.setFont(new Font("Arial", Font.PLAIN, 16));
        con.add(lblSales);
        lblSales.setBounds(190, 150, 200, 30);

        // REPORT Table
        model = DataStore.transactionModel;
        tblReports = new JTable(model);
                
        JScrollPane scroll = new JScrollPane(tblReports);
        scroll.setBounds(190, 250, 1400, 500);
        con.add(scroll);;
        

        // TOTAL SALES
        lblTotal = new JLabel("Total Sales");
        con.add(lblTotal);
        lblTotal.setBounds(1390, 210, 120, 20);

        txtTotal = new JTextField();
        con.add(txtTotal);
        txtTotal.setBounds(1470, 200, 120, 35);
        txtTotal.setEditable(false);
        String totalText = String.format("₱ %.2f", DataStore.getTotalAmount()); // get total
        txtTotal.setText(totalText);
        
        lblNote = new JLabel("Note: The (X) button is disabled. please use the menu to exit.");
        lblNote.setFont(new Font("Roboto", Font.BOLD, 12));
        lblNote.setForeground(Color.DARK_GRAY);
        lblNote.setBounds(10, 820, 400, 12);
        add(lblNote);
    }
    
    
}
