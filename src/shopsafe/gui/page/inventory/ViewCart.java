package shopsafe.gui.page.inventory;

import javax.swing.JButton;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.Window;

public class ViewCart extends JButton {
    
    protected ViewCart(User user, ShoppingCart shoppingCart) {        
        super("View Cart");

        Window window = Window.getInstance();

        addActionListener(e -> window.gotoShoppingCart(user, shoppingCart));
    }

}
