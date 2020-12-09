package shopsafe.gui.page.seller;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class InventorySelection extends JPanel {

    protected InventorySelection() {
        super(new GridLayout(0, 5));

        add(new ItemSelection(this, "images/television.png", "Television", "Buy it.", 199.99, 10));
    }
    
}
