package ShoppApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class NavMenu extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JFrame superFrame;
    JMenu menuSettings, menuProducts, menuUsers, menuReports;
    JMenuItem itmLogout, itmExit, itmViewProductsPage, itmViewUsersPage, itmViewReportsPage, itmAdminPage;

    public NavMenu(JFrame superFrame) {
        // Initializing sa menu bar
        menuBar = new JMenuBar();
        this.superFrame = superFrame;

        // initializings sa menu navigation
        menuSettings = new JMenu("Settings");
        menuProducts = new JMenu("Products");
        menuUsers = new JMenu("Users");
        menuReports = new JMenu("Reports");

        // initializings pud sa menu navigations items
        itmAdminPage = new JMenuItem("Admin Page");
        itmLogout = new JMenuItem("Logout");
        itmExit = new JMenuItem("Exit");
        itmViewProductsPage = new JMenuItem("View Products");
        itmViewUsersPage = new JMenuItem("View Users");
        itmViewReportsPage = new JMenuItem("View Reports");

        // initializing aaction listeners para sa menu
        itmAdminPage.addActionListener(this);
        itmLogout.addActionListener(this);
        itmExit.addActionListener(this);
        itmViewProductsPage.addActionListener(this);
        itmViewUsersPage.addActionListener(this);
        itmViewReportsPage.addActionListener(this);

        // add ang mga buttons sa menu items para mo navigate sa lain-laing pages
        menuSettings.add(itmAdminPage);
        menuSettings.add(itmLogout);
        menuSettings.add(itmExit);
        menuProducts.add(itmViewProductsPage);
        menuUsers.add(itmViewUsersPage);
        menuReports.add(itmViewReportsPage);

        // pang add sa menu items sa menu bar
        menuBar.add(menuSettings);
        menuBar.add(menuProducts);
        menuBar.add(menuUsers);
        menuBar.add(menuReports);

        // frame sa menu bar
        setJMenuBar(menuBar);
    }

    public void viewProducts(ActionEvent e) {
        ProductsPage p = new ProductsPage();
        p.setVisible(true);
        superFrame.dispose();
    }

    public void viewUsers(ActionEvent e) {
        UserPage u = new UserPage();
        u.setVisible(true);
        superFrame.dispose();
    }

    public void viewAdminPage(ActionEvent e) {
        AdminPage ap = new AdminPage();
        ap.setVisible(true);
        superFrame.dispose();
    }

    public void logOut(ActionEvent e) {
        LoginPage login = new LoginPage();
        JPanel bg = new JPanel();
        bg.setLayout(null);
        bg.setBounds(0, 130, 1800, 580);
        bg.setBackground(Color.BLACK);
        login.add(bg);

        JPanel bgPanel = new JPanel();
        bgPanel.setLayout(null);
        bgPanel.setBounds(1000, 90, 400, 400);
        bgPanel.setBackground(Color.WHITE);
        bg.add(bgPanel);
        
        login.setVisible(true);
        superFrame.dispose();
    }

    public void Exit(ActionEvent e) {
        System.exit(0);
    }

    public void viewReportsPage(ActionEvent e) {
        ReportsPage rp = new ReportsPage();
        rp.setVisible(true);
        superFrame.dispose();
    }

    public void setProductsMenuEnabled(boolean enabled) {
        itmViewProductsPage.setEnabled(enabled);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Handle action events for each menu item
        if (e.getSource() == itmAdminPage){
            viewAdminPage(e);
        }
        
        if (e.getSource() == itmViewProductsPage) {
            viewProducts(e);
        }

        if (e.getSource() == itmViewUsersPage) {
            viewUsers(e);
        }

        if (e.getSource() == itmViewReportsPage) {
            viewReportsPage(e);
        }
        
        if (e.getSource() == itmLogout) {
            logOut(e);
        }
        
        if (e.getSource() == itmExit) {
            Exit(e);
        }

    }
}
