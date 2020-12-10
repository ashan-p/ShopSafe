package shopsafe.gui.page.seller;

import javax.swing.JButton;

import shopsafe.Inventory;
import shopsafe.Item;
import shopsafe.User;
import shopsafe.gui.NamedSpinner;
import shopsafe.gui.NamedTextField;

public class AddProductSubmit extends JButton {
    
    protected AddProductSubmit(AddProductPopup parent, User user, InventorySelection inventorySelection, NamedTextField productName, NamedTextField description, NamedTextField basePrice, NamedTextField salePrice, NamedSpinner quantityInput, NamedTextField imagePath) {
        super("Create Product");
        Inventory inventory = Inventory.getInstance();

        addActionListener(e -> {
            try {
                Item item = new Item(productName.getValue(), quantityInput.getValue(), user);
                item.setDescription(description.getValue());
                item.setBasePrice(basePrice.getValue());
                item.setSalePrice(salePrice.getValue());
                item.setImagePath(imagePath.getValue());

                inventory.addItem(item);
                inventory.save();

                inventorySelection.refresh();
            } catch (Exception ex) {}

            parent.close();
        });
    }

}
