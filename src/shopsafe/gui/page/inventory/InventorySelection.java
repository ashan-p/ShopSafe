package shopsafe.gui.page.inventory;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GridLayout;

// Composite
public class InventorySelection extends JPanel {
    
    private JDialog currentPopup;

    protected InventorySelection() {
        super(new GridLayout(0, 5));

        for (int i = 0; i < 16; i++) {
            add(new ItemSelection(this, "images/television.png", "Television", "Buy it.", 199.99, 10));
        }
    }

    private boolean noActivePopup() {
        return currentPopup == null;
    }

    public void popupIfNone(String name, String description, ImageIcon image, double price, int available) {
        if (noActivePopup()) {
            currentPopup = new Popup(this, name, description, image, price, available);
        }
    }

    public void popupClosed() {
        currentPopup = null;
    }

}
