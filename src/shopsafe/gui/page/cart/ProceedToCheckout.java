package shopsafe.gui.page.cart;

import javax.swing.JButton;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.Window;

/**
 * Allows the user to proceed to the checkout page.
 * Makes use of the Observer pattern.
 * 
 * @author Ashan Perera
 */
public class ProceedToCheckout extends JButton {
    
    protected ProceedToCheckout(User user, ShoppingCart shoppingCart) {
        super("Proceed To Checkout");

        addActionListener(e -> Window.getInstance().gotoCheckout(user, shoppingCart));
    }

}
