package shopsafe.gui.page.checkout;

import javax.swing.JPanel;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.Window;

import java.awt.BorderLayout;

public class CheckoutPage extends JPanel {
    
    public CheckoutPage(User user, ShoppingCart shoppingCart) {
        Object[][] data = {
            {"TV", 1, 199.99},
            {"Abc", 2, 30.05},
        };

        BackToCart backToCart = new BackToCart(user, shoppingCart);
        Listings listings = new Listings(data);
        Footer footer = new Footer(user, shoppingCart);

        setLayout(new BorderLayout());

        add(backToCart, BorderLayout.PAGE_START);
        add(listings, BorderLayout.CENTER);
        add(footer, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        Window.getInstance().start();
        //Window.getInstance().gotoCheckout();
    }

}
