package shopsafe.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.page.cart.ShoppingCartPage;
import shopsafe.gui.page.checkout.CheckoutPage;
import shopsafe.gui.page.inventory.InventoryPage;
import shopsafe.gui.page.login.LoginPage;
import shopsafe.gui.page.seller.SellerPage;

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
        gotoLogin();
        setVisible(true);
    }

    public void gotoLogin() {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new LoginPage());
        contentPane.revalidate();
        contentPane.repaint();
    }

    public void gotoInventory(User user, ShoppingCart shoppingCart) {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new InventoryPage(user, shoppingCart));
        contentPane.revalidate();
        contentPane.repaint();
    }

    public void gotoShoppingCart(User user, ShoppingCart shoppingCart) {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new ShoppingCartPage(user, shoppingCart));
        contentPane.revalidate();
        contentPane.repaint();
    }

    public void gotoCheckout(User user, ShoppingCart shoppingCart) {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new CheckoutPage(user, shoppingCart));
        contentPane.revalidate();
        contentPane.repaint();
    }

    public void gotoSeller(User user) {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new SellerPage(user));
        contentPane.revalidate();
        contentPane.repaint();
    }

}
