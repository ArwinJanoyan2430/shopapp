package ShoppApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerPage extends JFrame implements ActionListener {

    JLabel lblLogo, lblBg, lblTitle, lblSubheading, lblMember;
    JButton btnExplore;
    Container con;

    public CustomerPage() {
        setTitle("Shop App Login");
        setBounds(0, 0, 1800, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        con = getContentPane();
        con.setLayout(null);

        ImageIcon icon = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/Logo.png")
        );
        Image imgIcon = icon
            .getImage()
            .getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        setIconImage(imgIcon);

        ImageIcon bg = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/CustomerBg.png")
        );

        Image img = bg
            .getImage()
            .getScaledInstance(1900, 1000, Image.SCALE_SMOOTH);
        ImageIcon resizedBg = new ImageIcon(img);

        ImageIcon logo = new ImageIcon(
            getClass().getResource("/ShoppApp/assets/Logo.png")
        );
        Image imgLogo = logo
            .getImage()
            .getScaledInstance(140, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(imgLogo);

        lblLogo = new JLabel(resizedLogo);
        lblLogo.setBounds(710, 320, 100, 100);
        con.add(lblLogo);

        lblTitle = new JLabel("Shop App");
        lblTitle.setFont(new Font("Roboto", Font.BOLD, 50));
        lblTitle.setBounds(810, 340, 300, 60);
        con.add(lblTitle);

        btnExplore = new JButton("Explore");
        btnExplore.setBounds(730, 430, 320, 40);
        btnExplore.setBackground(Color.BLACK);
        btnExplore.setForeground(Color.WHITE);
        btnExplore.setBorder(
            BorderFactory.createLineBorder(new Color(184, 134, 11), 2)
        );
        con.add(btnExplore);

        //Members
        lblSubheading = new JLabel("Made by:");
        lblSubheading.setFont(new Font("Roboto", Font.BOLD, 14));
        lblSubheading.setBounds(860, 710, 200, 30);
        con.add(lblSubheading);

        lblMember = new JLabel("Arwin Ryan C. Janoyan");
        lblMember.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblMember.setBounds(820, 730, 200, 30);
        con.add(lblMember);

        lblMember = new JLabel("Jeran Isaac Nonog");
        lblMember.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblMember.setBounds(830, 750, 200, 30);
        con.add(lblMember);

        lblMember = new JLabel("Gabriel Vicilla");
        lblMember.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblMember.setBounds(850, 770, 200, 30);
        con.add(lblMember);

        lblMember = new JLabel("Prince Tumale");
        lblMember.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblMember.setBounds(845, 790, 200, 30);
        con.add(lblMember);

        lblBg = new JLabel(resizedBg);
        lblBg.setBounds(0, -35, 1800, 900);
        con.add(lblBg);

        btnExplore.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnExplore.addActionListener(this);

        if (e.getSource() == btnExplore) {
            new CustomerShoppingPage().setVisible(true);
            this.dispose();
        }
    }
}
