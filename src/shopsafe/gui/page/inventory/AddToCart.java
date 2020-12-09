package shopsafe.gui.page.inventory;

import javax.swing.JButton;
import javax.swing.JLabel;

public class AddToCart extends JButton {

    protected AddToCart(Popup parent, Quantity quantity) {
        super("Add to cart");

        setAlignmentX(JLabel.CENTER_ALIGNMENT);
        addActionListener(e2 -> {
            System.out.println(quantity.getValue());
            parent.close();
        });
    }
    
}
