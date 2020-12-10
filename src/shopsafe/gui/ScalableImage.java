package shopsafe.gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Adapter
// Immutable
/**
 * @author Ashan Perera
 */
public class ScalableImage extends ImageIcon {

    public static ScalableImage createWithSize(String filename, int size) {
        return new ScalableImage(filename).scaleTo(size, size);
    }

    private ScalableImage(Image img) {
        super(img);
    }

    public ScalableImage(String filename) {
        super(filename);
    }

    public ScalableImage scaleTo(int width, int height) {
        Image image = this.getImage();
        Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ScalableImage(newImage);
    }

    public JLabel intoLabel() {
        JLabel label = new JLabel();
        label.setIcon(this);
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        return label;
    }
    
}
