package shopsafe.gui.page.seller;

import javax.swing.JButton;

import shopsafe.User;

public class AddProduct extends JButton {
    
    protected AddProduct(OnlyOneManager<AddProductPopup> manager, User user, InventorySelection inventorySelection) {
        super("Add Product");

        addActionListener(e -> {
            if (manager.noObject()) {
                manager.set(new AddProductPopup(manager, user, inventorySelection));
            }
        });
    }

}
