package shopsafe.gui.page.cart;

import javax.swing.JButton;

import shopsafe.gui.Window;

// Observer
public class ProceedToCheckout extends JButton {
    
    protected ProceedToCheckout() {
        super("Proceed To Checkout");

        addActionListener(e -> Window.getInstance().gotoCheckout());
    }

}
