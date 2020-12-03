package shopsafe;

import javax.swing.JFrame;
import javax.swing.JPanel;

import shopsafe.page.login.LoginPage;

/**
 * The Window class manages pages, allowing the user to visit a different page.
 * Can be implemented based on the Observer pattern.
 * 
 * Using the Singleton pattern.
 */

 // TODO: Look into using CardLayout
public class Window extends JFrame {

    private static Window instance = new Window("ShopSafe");
    public static Window getInstance() { return instance; }
    
    private Window(String title) {
        super(title);
        setSize(600, 480);
        setLocationRelativeTo(null);
        setResizable(false);                              // currently resizing disabled
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        add(new LoginPage());
        setVisible(true);
    }

    public void gotoInventory(User user) {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new InventoryPage(user));
        contentPane.revalidate();
        contentPane.repaint();
    }

}
