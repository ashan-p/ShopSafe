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
 * Using the Singleton and Observer patterns.
 * @author Ashan Perera
 */
public class Window extends JFrame {

    private static Window instance = new Window("ShopSafe");
    public static Window getInstance() { return instance; }
    
    /**
     * Creates a new Window instance.
     */
    private Window(String title) {
        super(title);
        setSize(600, 480);
        setLocationRelativeTo(null);
        setResizable(false);                              // currently resizing disabled
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Starts the window on the Login page.
     */
    public void start() {
        gotoLogin();
        setVisible(true);
    }

    /**
     * Goes to the Login page.
     */
    public void gotoLogin() {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new LoginPage());
        contentPane.revalidate();
        contentPane.repaint();
    }

    /**
     * Goes to the Inventory page.
     * @param user Current user.
     * @param shoppingCart User's shopping cart.
     */
    public void gotoInventory(User user, ShoppingCart shoppingCart) {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new InventoryPage(user, shoppingCart));
        contentPane.revalidate();
        contentPane.repaint();
    }

    /**
     * Goes to the Shopping Cart page.
     * @param user Current user.
     * @param shoppingCart User's shopping cart.
     */
    public void gotoShoppingCart(User user, ShoppingCart shoppingCart) {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new ShoppingCartPage(user, shoppingCart));
        contentPane.revalidate();
        contentPane.repaint();
    }

    /**
     * Goes to the Checkout page.
     * @param user Current user.
     * @param shoppingCart User's shopping cart.
     */
    public void gotoCheckout(User user, ShoppingCart shoppingCart) {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new CheckoutPage(user, shoppingCart));
        contentPane.revalidate();
        contentPane.repaint();
    }

    /**
     * Goes to the Seller page.
     * @param user Current user.
     */
    public void gotoSeller(User user) {
        JPanel contentPane = (JPanel)getContentPane();

        contentPane.removeAll();
        contentPane.add(new SellerPage(user));
        contentPane.revalidate();
        contentPane.repaint();
    }

}
