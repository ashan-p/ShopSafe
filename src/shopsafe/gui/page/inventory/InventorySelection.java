package shopsafe.gui.page.inventory;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import shopsafe.Inventory;
import shopsafe.Item;
import shopsafe.ShoppingCart;

import java.awt.GridLayout;
import java.util.ArrayList;

/**
 * Displays all the items available to the customer. Makes use of the Composite pattern.
 * 
 * @author Ashan Perera
 */
public class InventorySelection extends JPanel {
    
    private JDialog currentPopup;
    private ShoppingCart shoppingCart;

    protected InventorySelection(ShoppingCart shoppingCart) {
        super(new GridLayout(0, 5));
        this.shoppingCart = shoppingCart;
        
        refresh();
    }

    public void refresh() {
        Inventory inventory = Inventory.getInstance();
        removeAll();
        revalidate();
        repaint();

        ArrayList<Item> items = inventory.getItems(inventory.getSize());
        for (Item item : items) {
            add(new ItemSelection(this, shoppingCart, item));
        }
    }

    private boolean noActivePopup() {
        return currentPopup == null;
    }

    public void popupIfNone(ImageIcon image, ShoppingCart shoppingCart, Item item) {
        if (noActivePopup()) {
            currentPopup = new Popup(this, shoppingCart, image, item);
        }
    }

    public void popupClosed() {
        currentPopup = null;
    }

}
