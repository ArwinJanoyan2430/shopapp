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
import javax.swing.table.DefaultTableModel;

public class AdminPage extends JFrame implements ActionListener {

    Container con;

    //labels
    JLabel lblTitle, lblLogo, lblNote;

    //buttons
    JButton btnViewProducts, btnViewUsers, btnViewReports;
    DefaultTableModel model;

    public AdminPage() {
        setTitle("Admin Panel");
        setBounds(0, 0, 1800, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        con = getContentPane();
        con.setLayout(null);

        NavMenu nav = new NavMenu(this);
        setJMenuBar(nav.menuBar);

        ImageIcon icon = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/Logo.png")
        );
        Image imgIcon = icon
            .getImage()
            .getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        setIconImage(imgIcon);

        //Title
        ImageIcon logo = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/Logo.png")
        );
        Image img = logo
            .getImage()
            .getScaledInstance(140, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(img);

        lblLogo = new JLabel(resizedLogo);
        lblLogo.setBounds(610, 300, 100, 100);
        con.add(lblLogo);

        lblTitle = new JLabel("Shop App");
        lblTitle.setFont(new Font("Roboto", Font.BOLD, 50));
        lblTitle.setBounds(720, 320, 300, 60);
        con.add(lblTitle);

        lblTitle = new JLabel("Admin");
        lblTitle.setFont(new Font("Roboto", Font.BOLD, 50));
        lblTitle.setBounds(990, 320, 300, 60);
        con.add(lblTitle);

        btnViewProducts = new JButton("View Products");
        btnViewProducts.setBounds(625, 420, 150, 35);
        btnViewProducts.setBackground(Color.BLACK);
        btnViewProducts.setForeground(Color.WHITE);
        con.add(btnViewProducts);

        btnViewUsers = new JButton("View Users");
        btnViewUsers.setBounds(820, 420, 150, 35);
        btnViewUsers.setBackground(Color.BLACK);
        btnViewUsers.setForeground(Color.WHITE);
        con.add(btnViewUsers);

        btnViewReports = new JButton("View Reports");
        btnViewReports.setBounds(1015, 420, 150, 35);
        btnViewReports.setBackground(Color.BLACK);
        btnViewReports.setForeground(Color.WHITE);
        con.add(btnViewReports);
        
        lblNote = new JLabel("Note: The (X) button is disabled. please use the menu to exit.");
        lblNote.setFont(new Font("Roboto", Font.BOLD, 12));
        lblNote.setForeground(Color.DARK_GRAY);
        lblNote.setBounds(10, 820, 400, 12);
        add(lblNote);

        btnViewProducts.addActionListener(this);
        btnViewUsers.addActionListener(this);
        btnViewReports.addActionListener(this);
    }

    // product page button ni sya HAHAHAHHAHAHAHAHAHAHAHA
    public void productsPage() {
        ProductsPage p = new ProductsPage();
        p.setVisible(true);
    }

    // sa users page button ni sya HAHAHAHHAHAHAHAHAHAHAHA
    public void userPage() {
        UserPage u = new UserPage();
        u.setVisible(true);
    }

    // reports page button ni sya HAHAHAHHAHAHAHAHAHAHAHA
    public void reportsPage() {
        ReportsPage r = new ReportsPage();
        r.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnViewProducts) {
            productsPage();
            this.dispose();
        }

        if (e.getSource() == btnViewUsers) {
            userPage();
            this.dispose();
        }

        if (e.getSource() == btnViewReports) {
            reportsPage();
            this.dispose();
        }
    }
}
