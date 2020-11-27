import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class InventoryPage extends JPanel {

    public static ImageIcon scaleImageIcon (ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        return new ImageIcon(newimg);  // transform it back
    }
    
    public InventoryPage(User user) {
        Inventory inventory = Inventory.getInstance();

        setLayout(new GridLayout(0, 5));
        ImageIcon image = scaleImageIcon(new ImageIcon("images/table.png"), 64, 64);
        for (int i = 1; i <= 16; i++) {
            JLabel label = new JLabel();
            label.setIcon(image);
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT);

            JButton button = new JButton();
            button.add(label);

            add(button);
        }
    }

    public static void main(String[] args) {
        Window.getInstance().start();
        Window.getInstance().gotoInventory(null);
    }

}
