package shopsafe.gui.page.checkout;

import javax.swing.JButton;

import shopsafe.gui.Window;

public class BackToCart extends JButton {

    protected BackToCart() {
        super("Back to Cart");

        addActionListener(e -> Window.getInstance().gotoShoppingCart());
    }
    
}
