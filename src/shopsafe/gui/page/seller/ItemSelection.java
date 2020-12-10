package shopsafe.gui.page.seller;

import shopsafe.Item;
import shopsafe.gui.ScalableImage;

import javax.swing.JButton;
import javax.swing.JLabel;

// Composite
// Observer
public class ItemSelection extends JButton {
    
    private static final int IMAGE_SIZE = 85;

    protected ItemSelection(OnlyOneManager<ViewProductPopup> manager, InventorySelection inventorySelection, Item item) {
        ScalableImage image = ScalableImage.createWithSize(item.getImagePath(), IMAGE_SIZE);
        JLabel imageLabel = image.intoLabel();

        add(imageLabel);
        addActionListener(e -> {
            if (manager.noObject()) {
                manager.set(new ViewProductPopup(manager, inventorySelection, image, item));
            }
        });
    }

}
