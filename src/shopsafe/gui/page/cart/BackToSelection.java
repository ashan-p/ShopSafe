package shopsafe.gui.page.cart;

import javax.swing.JButton;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.Window;

/**
 * Returns the user to the selection screen. Makes use of the Observer pattern.
 * 
 * @author Ashan Perera
 */
public class BackToSelection extends JButton {
    
    protected BackToSelection(User user, ShoppingCart shoppingCart) {
        super("Back to Selection");

        addActionListener(e -> Window.getInstance().gotoInventory(user, shoppingCart));
    }

}
