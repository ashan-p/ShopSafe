package shopsafe.gui.page.checkout;

import javax.swing.JButton;

public class Purchase extends JButton {

    protected Purchase(Footer parent) {
        super("Purchase");

        addActionListener(e -> parent.popupIfNone());
    }
    
}
