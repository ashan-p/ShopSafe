package shopsafe.gui.page.inventory;

import javax.swing.JButton;

import shopsafe.gui.Window;

public class ViewCart extends JButton {
    
    protected ViewCart() {        
        super("View Cart");

        Window window = Window.getInstance();

        addActionListener(e -> window.gotoShoppingCart());
    }

}
