package shopsafe.gui.page.checkout;

import javax.swing.JPanel;

import shopsafe.gui.Window;

import java.awt.BorderLayout;

public class CheckoutPage extends JPanel {
    
    public CheckoutPage() {
        Object[][] data = {
            {"TV", 1, 199.99},
            {"Abc", 2, 30.05},
        };

        BackToCart backToCart = new BackToCart();
        Listings listings = new Listings(data);
        Footer footer = new Footer();

        setLayout(new BorderLayout());

        add(backToCart, BorderLayout.PAGE_START);
        add(listings, BorderLayout.CENTER);
        add(footer, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        Window.getInstance().start();
        Window.getInstance().gotoCheckout();
    }

}
