package shopsafe.gui.page.cart;

import javax.swing.JButton;

import shopsafe.gui.Window;

// Observer
public class BackToSelection extends JButton {
    
    protected BackToSelection() {
        super("Back to Selection");

        addActionListener(e -> Window.getInstance().gotoInventory(null));
    }

}
