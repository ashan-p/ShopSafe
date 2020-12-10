package shopsafe.gui.page.inventory;

import javax.swing.JButton;
import javax.swing.JLabel;

import shopsafe.Item;
import shopsafe.ShoppingCart;

public class AddToCart extends JButton {

    protected AddToCart(Popup parent, ShoppingCart shoppingCart, Quantity quantity, Item item) {
        super("Add to cart");

        setAlignmentX(JLabel.CENTER_ALIGNMENT);
        addActionListener(e2 -> {
            shoppingCart.addItem(item);

            parent.close();
        });
    }
    
}
