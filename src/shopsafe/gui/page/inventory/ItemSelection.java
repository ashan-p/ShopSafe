package shopsafe.gui.page.inventory;

import javax.swing.JButton;
import javax.swing.JLabel;

import shopsafe.Item;
import shopsafe.ShoppingCart;
import shopsafe.gui.ScalableImage;

// Composite
// Observer
public class ItemSelection extends JButton {
    
    private static final int IMAGE_SIZE = 85;

    protected ItemSelection(InventorySelection parent, ShoppingCart shoppingCart, Item item) {
        ScalableImage image = ScalableImage.createWithSize(item.getImagePath(), IMAGE_SIZE);
        JLabel imageLabel = image.intoLabel();

        add(imageLabel);
        addActionListener(e -> {
            parent.popupIfNone(image, shoppingCart, item);
        });
    }

}
