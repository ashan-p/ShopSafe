package shopsafe.gui.page.checkout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import shopsafe.ShoppingCart;
import shopsafe.User;

import java.awt.GridLayout;

public class Footer extends JPanel {
    
    private Popup currentPopup;

    protected Footer(User user, ShoppingCart shoppingCart) {
        setLayout(new GridLayout(2, 0));

        JLabel priceLabel = new JLabel("Total price: $999.88");
        Purchase purchase = new Purchase(this, user, shoppingCart);

        add(priceLabel);
        add(purchase);
    }

    private boolean noActivePopup() {
        return currentPopup == null;
    }

    public void popupIfNone(User user, ShoppingCart shoppingCart) {
        if (noActivePopup()) {
            currentPopup = new Popup(this, user, shoppingCart);
        }
    }

    public void popupClosed() {
        currentPopup = null;
    }

}
