package shopsafe.gui.page.inventory;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import shopsafe.Inventory;
import shopsafe.User;
import shopsafe.gui.Window;

import javax.swing.Box;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;

import java.text.NumberFormat;

public class InventoryPageOld extends JPanel {

    public static ImageIcon scaleImageIcon(ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg); // transform it back
    }

    JDialog currentPopup;

    public InventoryPageOld(User user) {
        Window window = Window.getInstance();
        Inventory inventory = Inventory.getInstance();

        setLayout(new BorderLayout());

        JPanel inventorySelection = new JPanel(new GridLayout(0, 5));

        int size = 85;
        ImageIcon image = scaleImageIcon(new ImageIcon("images/television.png"), size, size);
        for (int i = 1; i <= 16; i++) {
            JLabel label = new JLabel();
            label.setIcon(image);
            label.setAlignmentX(JLabel.CENTER_ALIGNMENT);

            double price = 199.99;
            int available = 10;

            JButton button = new JButton();
            button.add(label);
            button.addActionListener(e -> {
                if (!isPopupActive()) {
                    currentPopup = new JDialog(window, "Television");
                    currentPopup.setLayout(new GridBagLayout());
                    currentPopup.setSize(350, 400); 

                    JPanel content = new JPanel();
                    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

                    JTextArea description = new JTextArea(0, 20);
                    description.setText("A sturdy hand-crafted television, made in the highest mountains where signals live best. Audio and remote not included.");
                    description.setWrapStyleWord(true);
                    description.setLineWrap(true);
                    description.setOpaque(false);
                    description.setEditable(false);
                    description.setFocusable(false);
                    description.setAlignmentX(JLabel.CENTER_ALIGNMENT);

                    JLabel picture = new JLabel();
                    picture.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                    picture.setIcon(image);

                    JLabel priceLabel = new JLabel("Total price: $" + price);
                    priceLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

                    JLabel availableLabel = new JLabel("Available: " + available);
                    availableLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

                    JLabel quantityLabel = new JLabel("Quantity");
                    quantityLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

                    SpinnerModel quantityBounds = new SpinnerNumberModel(1, 1, available, 1);
                    JSpinner quantityInput = new JSpinner(quantityBounds);
                    
                    quantityInput.addChangeListener(e2 -> {
                        double totalPrice =  price * (int)quantityInput.getValue();
                        String formattedPrice = NumberFormat.getCurrencyInstance().format(totalPrice);
                        priceLabel.setText("Total price: " + formattedPrice);
                    });

                    JButton addToCart = new JButton("Add to cart");
                    addToCart.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                    addToCart.addActionListener(e2 -> {
                        System.out.println(quantityInput.getValue());
                        currentPopup.dispose();
                        currentPopup = null;
                    });

                    content.add(picture);
                    content.add(Box.createVerticalStrut(20));
                    content.add(description);
                    content.add(Box.createVerticalStrut(30));
                    content.add(availableLabel);
                    content.add(priceLabel);
                    content.add(Box.createVerticalStrut(20));
                    content.add(quantityLabel);
                    content.add(Box.createVerticalStrut(10));
                    content.add(quantityInput);
                    content.add(Box.createVerticalStrut(20));
                    content.add(addToCart);
                    content.add(Box.createVerticalStrut(10));

                    currentPopup.add(content, new GridBagConstraints());

                    currentPopup.addWindowListener(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void windowClosing(WindowEvent e) {
                            currentPopup = null;
                        }

                        @Override
                        public void windowClosed(WindowEvent e) {
                        }

                        @Override
                        public void windowIconified(WindowEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void windowDeiconified(WindowEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void windowActivated(WindowEvent e) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void windowDeactivated(WindowEvent e) {
                            // TODO Auto-generated method stub

                        }
                    });
        
                    currentPopup.setLocationRelativeTo(window);
                    currentPopup.setVisible(true);
                }
            });

            inventorySelection.add(button);
        }

        add(new JButton("View Cart"), BorderLayout.PAGE_START);
        add(inventorySelection, BorderLayout.CENTER);
    }

    private boolean isPopupActive() {
        return currentPopup != null;
    }

    public static void main(String[] args) {
        Window.getInstance().start();
        Window.getInstance().gotoInventory(null);
    }

}
