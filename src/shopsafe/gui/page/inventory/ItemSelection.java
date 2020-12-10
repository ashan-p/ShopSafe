package shopsafe.gui.page.inventory;

import javax.swing.JButton;
import javax.swing.JLabel;

import shopsafe.Item;
import shopsafe.ShoppingCart;
import shopsafe.gui.ScalableImage;

/**
 * A selection for a specific item. Makes use of the Composite and Observer patterns.
 * 
 * @author Ashan Perera
 */
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
