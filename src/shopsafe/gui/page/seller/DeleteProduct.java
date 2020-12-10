package shopsafe.gui.page.seller;

import javax.swing.JButton;

import shopsafe.Inventory;
import shopsafe.Item;

public class DeleteProduct extends JButton {
    
    protected DeleteProduct(ViewProductPopup parent, InventorySelection inventorySelection, Item item) {
        super("Delete");

        addActionListener(e -> {
            Inventory.getInstance().removeItem(item);

            inventorySelection.refresh();

            parent.close();
        });
    }

}
