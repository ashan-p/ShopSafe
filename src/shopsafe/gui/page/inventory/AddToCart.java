package shopsafe.gui.page.inventory;

import javax.swing.JButton;
import javax.swing.JLabel;

import shopsafe.Item;
import shopsafe.ShoppingCart;

/**
 * Adds the item to the shopping cart with the specified quantity.
 * 
 * @author Ashan Perera
 */
public class AddToCart extends JButton {

    protected AddToCart(Popup parent, ShoppingCart shoppingCart, Quantity quantity, Item item) {
        super("Add to cart");

        setAlignmentX(JLabel.CENTER_ALIGNMENT);
        addActionListener(e2 -> {
            Item i = shoppingCart.addItem(item);
            
            for (int j = 1; j < quantity.getValue(); j++) {
                i.incrementQuantity();
            }

            parent.close();
        });
    }
    
}
