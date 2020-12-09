package shopsafe.gui.page.inventory;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Picture extends JLabel {
    
    protected Picture(ImageIcon image) {
        setAlignmentX(JLabel.CENTER_ALIGNMENT);
        setIcon(image);
    }

}
