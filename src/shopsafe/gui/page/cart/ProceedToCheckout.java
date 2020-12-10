package shopsafe.gui.page.cart;

import javax.swing.JButton;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.Window;

// Observer
public class ProceedToCheckout extends JButton {
    
    protected ProceedToCheckout(User user, ShoppingCart shoppingCart) {
        super("Proceed To Checkout");

        addActionListener(e -> Window.getInstance().gotoCheckout(user, shoppingCart));
    }

}
