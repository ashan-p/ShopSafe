package shopsafe.gui.page.inventory;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A picture represented in a JLabel. Makes use of the Decorator pattern.
 * 
 * @author Ashan Perera
 */
public class Picture extends JLabel {
    
    protected Picture(ImageIcon image) {
        setAlignmentX(JLabel.CENTER_ALIGNMENT);
        setIcon(image);
    }

}
