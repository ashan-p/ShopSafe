package shopsafe.gui.page.checkout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Footer extends JPanel {
    
    private Popup currentPopup;

    protected Footer() {
        setLayout(new GridLayout(2, 0));

        JLabel priceLabel = new JLabel("Total price: $999.88");
        Purchase purchase = new Purchase(this);

        add(priceLabel);
        add(purchase);
    }

    private boolean noActivePopup() {
        return currentPopup == null;
    }

    public void popupIfNone() {
        if (noActivePopup()) {
            currentPopup = new Popup(this);
        }
    }

    public void popupClosed() {
        currentPopup = null;
    }

}
