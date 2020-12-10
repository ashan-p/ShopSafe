package shopsafe.gui.page.checkout;

import javax.swing.JButton;

import shopsafe.ShoppingCart;
import shopsafe.User;

/**
 * Creates a popup for purchasing if none is already open.
 * 
 * @author Ashan Perera
 */
public class Purchase extends JButton {

    protected Purchase(Footer parent, User user, ShoppingCart shoppingCart) {
        super("Purchase");

        addActionListener(e -> parent.popupIfNone(user, shoppingCart));
    }
    
}
