package shopsafe.gui.page.checkout;

import javax.swing.JPanel;

import shopsafe.Item;
import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.Window;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class CheckoutPage extends JPanel {
    
    public CheckoutPage(User user, ShoppingCart shoppingCart) {
        double totalPrice = 0;

        Object[][] data = new Object[shoppingCart.size()][];
        for (int i = 0; i < shoppingCart.size(); i++) {
            Item item = shoppingCart.getItems().get(i);
            Object[] row = new Object[]{item.getItemName(), item.getQuantity(), item.getSalePriceAsDouble()};
            data[i] = row;
            totalPrice += item.getQuantity() * item.getSalePriceAsDouble();
        }

        BackToCart backToCart = new BackToCart(user, shoppingCart);
        Listings listings = new Listings(data);
        Footer footer = new Footer(user, shoppingCart, totalPrice);

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
