package shopsafe.gui.page.cart;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.Box;

public class Listings extends JPanel {

    protected Listings() {
        Names names = new Names();
        Quantities quantities = new Quantities();
        setLayout(new GridLayout(0, 2));

        names.add("cart");
        names.add("television");

        quantities.add(1, 10);
        quantities.add(5, 10);

        add(names);
        add(quantities);
        Box.Filler glue = (Box.Filler)Box.createVerticalGlue();
        glue.changeShape(glue.getMinimumSize(), 
                        new Dimension(0, Short.MAX_VALUE),
                        glue.getMaximumSize());
        quantities.add(glue);
    }

}
