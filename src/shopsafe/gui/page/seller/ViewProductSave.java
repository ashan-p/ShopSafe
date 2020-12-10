package shopsafe.gui.page.seller;

import javax.swing.JButton;

import shopsafe.Inventory;
import shopsafe.Item;
import shopsafe.gui.NamedSpinner;
import shopsafe.gui.NamedTextField;

public class ViewProductSave extends JButton {

    protected ViewProductSave(ViewProductPopup parent, InventorySelection inventorySelection, Item item, NamedTextField descriptionInput, NamedTextField basePriceInput, NamedTextField salePriceInput, NamedSpinner quantityInput, NamedTextField imagePathInput) {
        super("Save");

        addActionListener(e -> {
            item.setDescription(descriptionInput.getValue());
            item.setBasePrice(basePriceInput.getValue());
            item.setSalePrice(salePriceInput.getValue());
            item.setQuantity(quantityInput.getValue());
            item.setImagePath(imagePathInput.getValue());

            Inventory.getInstance().save();
            inventorySelection.refresh();

            parent.close();
        });
    }
    
}
