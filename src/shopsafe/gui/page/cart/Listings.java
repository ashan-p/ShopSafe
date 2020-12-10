package shopsafe.gui.page.cart;

import javax.swing.JPanel;
import javax.swing.JSpinner;

import shopsafe.Item;
import shopsafe.ShoppingCart;

import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.Box;

/**
 * Lists out all the items in the shopping cart by name and quantity.
 * Makes use of the Composite pattern.
 * 
 * @author Ashan Perera
 */
public class Listings extends JPanel {

    protected Listings(ShoppingCart shoppingCart) {
        Names names = new Names();
        Quantities quantities = new Quantities();
        setLayout(new GridLayout(0, 2));

        for (Item item : shoppingCart.getItems()) {
            names.add(item.getItemName());

            JSpinner input = quantities.add(item.getQuantity(), item.getQuantity());
            input.addChangeListener(e -> {
                item.setQuantity((Integer)input.getValue());
            });
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
