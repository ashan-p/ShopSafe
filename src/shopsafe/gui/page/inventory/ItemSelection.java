package shopsafe.gui.page.inventory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

// Composite
// Observer
public class ItemSelection extends JButton {
    
    private static final int IMAGE_SIZE = 85;

    protected ItemSelection(InventorySelection parent, String filename, String name, String description, double price, int available) {
        ScalableImage image = ScalableImage.createWithSize(filename, IMAGE_SIZE);
        JLabel imageLabel = image.intoLabel();

        add(imageLabel);
        addActionListener(e -> {
            parent.popupIfNone(name, description, image, price, available);
        });
    }

}
