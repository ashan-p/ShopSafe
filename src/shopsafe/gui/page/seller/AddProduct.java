package shopsafe.gui.page.seller;

import javax.swing.JButton;

public class AddProduct extends JButton {
    
    protected AddProduct(OnlyOneManager<AddProductPopup> manager) {
        super("Add Product");

        addActionListener(e -> {
            if (manager.noObject()) {
                manager.set(new AddProductPopup(manager));
            }
        });
    }

}
