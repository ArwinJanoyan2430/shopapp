package ShoppApp;

import ShoppApp.controller.DataStore;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener {

    Container con;
    JLabel lblTitle, lblUsername, lblPassword, lblSubheading, lblMember;
    JButton btnLogin;
    JTextField txtUserName;
    JPasswordField txtPassword;

    public LoginPage() {
        setTitle("Shop App Login");
        setBounds(0, 0, 1800, 900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        con = getContentPane();
        con.setLayout(null);

        //Images
        ImageIcon icon = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/Logo.png")
        );
        Image imgIcon = icon
            .getImage()
            .getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        setIconImage(imgIcon);

        ImageIcon graphics = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/loginGraphics.png")
        );

        JLabel lblGraphics = new JLabel(graphics);
        lblGraphics.setBounds(290, 60, 700, 700);
        con.add(lblGraphics);

        ImageIcon umLogo = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/umtcLogo.png")
        );
        Image imgUMlogo = umLogo
            .getImage()
            .getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedUMLogo = new ImageIcon(imgUMlogo);

        JLabel lblUMLogo = new JLabel(resizedUMLogo);
        lblUMLogo.setBounds(1600, 10, 110, 110);
        con.add(lblUMLogo);

        ImageIcon logo = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/Logo.png")
        );
        Image img = logo
            .getImage()
            .getScaledInstance(140, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(img);

        JLabel lblLogo = new JLabel(resizedLogo);
        lblLogo.setBounds(50, 10, 100, 100);
        con.add(lblLogo);

        //title
        lblTitle = new JLabel("Shop App");
        lblTitle.setFont(new Font("Roboto", Font.BOLD, 50));
        lblTitle.setBounds(170, 30, 300, 60);
        con.add(lblTitle);

        lblTitle = new JLabel("Shop App");
        lblTitle.setFont(new Font("Roboto", Font.BOLD, 50));
        lblTitle.setBounds(1075, 290, 300, 60);
        con.add(lblTitle);

        //Username
        lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblUsername.setBounds(1050, 390, 200, 30);
        con.add(lblUsername);

        txtUserName = new JTextField();
        txtUserName.setBounds(1150, 390, 200, 35);
        txtUserName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        con.add(txtUserName);

        //Password
        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblPassword.setBounds(1050, 440, 200, 30);
        con.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(1150, 440, 200, 35);
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        con.add(txtPassword);

        //Login Button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(1050, 500, 300, 40);
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.WHITE);
        con.add(btnLogin);

        //Members
        lblSubheading = new JLabel("Made by:");
        lblSubheading.setFont(new Font("Roboto", Font.BOLD, 14));
        lblSubheading.setBounds(90, 730, 200, 30);
        con.add(lblSubheading);

        lblMember = new JLabel("Arwin Ryan C. Janoyan");
        lblMember.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblMember.setBounds(90, 750, 200, 30);
        con.add(lblMember);

        lblMember = new JLabel("Jeran Isaac Nonog");
        lblMember.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblMember.setBounds(90, 770, 200, 30);
        con.add(lblMember);

        lblMember = new JLabel("Gabriel Vicilla");
        lblMember.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblMember.setBounds(90, 790, 200, 30);
        con.add(lblMember);

        lblMember = new JLabel("Prince Tumale");
        lblMember.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblMember.setBounds(90, 810, 200, 30);
        con.add(lblMember);
        
        btnLogin.addActionListener(this);
        txtUserName.addActionListener(this);
        txtPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AdminPage ap = new AdminPage();
        CustomerPage cp = new CustomerPage();

        // DEFAULT CREDENTIAL PARA SA CUSTOMER AND AMIN FOR DEMONSTRATION PURPOSES.
        if (e.getSource() == btnLogin) {
            String username = txtUserName.getText();
            String password = new String(txtPassword.getPassword());

            if (
                username.equalsIgnoreCase("admin") &&
                password.equalsIgnoreCase("admin")
            ) {
                JOptionPane.showMessageDialog(this, "Admin Login Successful!");

                // admin page
                ap.setVisible(true);
                this.dispose();
            } else {
                boolean found = false;
                // Loop through all users in DataStore
                for (int i = 0; i < DataStore.userModel.getRowCount(); i++) {
                    String u = DataStore.userModel.getValueAt(i, 1).toString(); // username
                    String p = DataStore.userModel.getValueAt(i, 2).toString(); // password

                    if (username.equals(u) && password.equals(p)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Customer Login Successful!"
                    );

                    cp.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(
                        this,
                        "Invalid username or password!"
                    );
                }
            }
        }
    }

    public static void main(String[] args) {
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
    }
}
