package shopsafe.gui.page.checkout;

import javax.swing.JButton;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.Window;

/**
 * Transitions the user back to the shopping cart page.
 * 
 * @author Ashan Perera
 */
public class BackToCart extends JButton {

    protected BackToCart(User user, ShoppingCart shoppingCart) {
        super("Back to Cart");

        addActionListener(e -> Window.getInstance().gotoShoppingCart(user, shoppingCart));
    }
    
}
