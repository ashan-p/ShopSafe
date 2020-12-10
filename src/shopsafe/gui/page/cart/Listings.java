package shopsafe.gui.page.cart;

import javax.swing.JPanel;

import shopsafe.Item;
import shopsafe.ShoppingCart;

import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.Box;

public class Listings extends JPanel {

    protected Listings(ShoppingCart shoppingCart) {
        Names names = new Names();
        Quantities quantities = new Quantities();
        setLayout(new GridLayout(0, 2));

        for (Item item : shoppingCart.getItems()) {
            
        }

        add(names);
        add(quantities);
        Box.Filler glue = (Box.Filler)Box.createVerticalGlue();
        glue.changeShape(glue.getMinimumSize(), 
                        new Dimension(0, Short.MAX_VALUE),
                        glue.getMaximumSize());
        quantities.add(glue);
    }

}
