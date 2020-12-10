package shopsafe.gui.page.checkout;

import javax.swing.JButton;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.Window;

public class BackToCart extends JButton {

    protected BackToCart(User user, ShoppingCart shoppingCart) {
        super("Back to Cart");

        addActionListener(e -> Window.getInstance().gotoShoppingCart(user, shoppingCart));
    }
    
}
