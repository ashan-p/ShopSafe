import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Box;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class InventoryPage extends JPanel {

    public static ImageIcon scaleImageIcon (ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        return new ImageIcon(newimg);  // transform it back
    }
    
    public InventoryPage(User user) {
        Window window = Window.getInstance();
        Inventory inventory = Inventory.getInstance();

        setLayout(new GridLayout(0, 5));
        int size = 85;
        ImageIcon image = scaleImageIcon(new ImageIcon("images/television.png"), size, size);
        for (int i = 1; i <= 16; i++) {
            JLabel label = new JLabel();
            label.setIcon(image);
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT);

            JButton button = new JButton();
            button.add(label);
            button.addActionListener(e -> {
                JDialog dialog = new JDialog(window, "Television");
                dialog.setLayout(new GridBagLayout());

                JPanel content = new JPanel();
                content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
                
                JLabel picture = new JLabel();
                picture.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                picture.setIcon(image);

                JLabel title = new JLabel("Television");
                title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

                content.add(picture);
                content.add(Box.createVerticalStrut(30));
                content.add(title);

                dialog.add(content, new GridBagConstraints());
    
                // setsize of dialog 
                dialog.setSize(350, 300); 
                dialog.setLocationRelativeTo(window);
                dialog.setVisible(true);
            });

            add(button);
        }
    }

    public static void main(String[] args) {
        Window.getInstance().start();
        Window.getInstance().gotoInventory(null);
    }

}
