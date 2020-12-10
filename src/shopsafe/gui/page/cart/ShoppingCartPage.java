package shopsafe.gui.page.cart;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.Window;

public class ShoppingCartPage extends JPanel {
    
    public ShoppingCartPage(User user, ShoppingCart shoppingCart) {
        BackToSelection backToSelection = new BackToSelection(user, shoppingCart);
        Listings listings = new Listings(shoppingCart);
        ProceedToCheckout proceedToCheckout = new ProceedToCheckout(user, shoppingCart);

        setLayout(new BorderLayout());

        add(backToSelection, BorderLayout.PAGE_START);
        add(listings, BorderLayout.CENTER);
        add(proceedToCheckout, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        Window.getInstance().start();
        //Window.getInstance().gotoShoppingCart(null);
    }

}
