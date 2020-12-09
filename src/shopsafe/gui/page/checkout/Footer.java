package shopsafe.gui.page.checkout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Footer extends JPanel {
    
    protected Footer() {
        setLayout(new GridLayout(2, 0));

        JLabel priceLabel = new JLabel("Total price: $999.88");
        Purchase purchase = new Purchase();

        add(priceLabel);
        add(purchase);
    }

}
