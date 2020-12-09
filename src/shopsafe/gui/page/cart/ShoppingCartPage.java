package shopsafe.gui.page.cart;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import shopsafe.gui.Window;

public class ShoppingCartPage extends JPanel {
    
    public ShoppingCartPage() {
        BackToSelection backToSelection = new BackToSelection();
        Listings listings = new Listings();
        ProceedToCheckout proceedToCheckout = new ProceedToCheckout();

        setLayout(new BorderLayout());

        add(backToSelection, BorderLayout.PAGE_START);
        add(listings, BorderLayout.CENTER);
        add(proceedToCheckout, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        Window.getInstance().start();
        Window.getInstance().gotoShoppingCart();
    }

}
