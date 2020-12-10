package shopsafe.gui.page.seller;

import javax.swing.JPanel;

import shopsafe.Inventory;
import shopsafe.Item;

import java.awt.GridLayout;
import java.util.ArrayList;

public class InventorySelection extends JPanel {

    private OnlyOneManager<ViewProductPopup> popupManager;

    protected InventorySelection() {
        super(new GridLayout(0, 5));
        popupManager = new OnlyOneManager<>();
        
        refresh();
    }

    public void refresh() {
        Inventory inventory = Inventory.getInstance();
        removeAll();
        revalidate();
        repaint();

        ArrayList<Item> items = inventory.getItems(inventory.getSize());
        for (Item item : items) {
            add(new ItemSelection(popupManager, this, item));
        }
    }
    
}
