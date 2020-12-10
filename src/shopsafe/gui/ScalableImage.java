package shopsafe.gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * An Immutable Image Icon that can be rescaled. Makes use of Adapter pattern.
 * @author Ashan Perera
 */
public class ScalableImage extends ImageIcon {

    /**
     * Creates new image with size.
     * @param filename Path to image
     * @param size Size of image
     * @return New scalable image
     */
    public static ScalableImage createWithSize(String filename, int size) {
        return new ScalableImage(filename).scaleTo(size, size);
    }

    /**
     * Creates new Scalable image from image icon.
     */
    private ScalableImage(Image img) {
        super(img);
    }

    /**
     * Creates new Scalable image from filename.
     */
    public ScalableImage(String filename) {
        super(filename);
    }

    /**
     * Scales the image to the appropriate width and height.
     */
    public ScalableImage scaleTo(int width, int height) {
        Image image = this.getImage();
        Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ScalableImage(newImage);
    }

    /**
     * Returns a copy of the image into a label.
     * @return The image label
     */
    public JLabel intoLabel() {
        JLabel label = new JLabel();
        label.setIcon(this);
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        return label;
    }
    
}
