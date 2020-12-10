package shopsafe.gui.page.inventory;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import shopsafe.Item;
import shopsafe.ShoppingCart;
import shopsafe.gui.Window;

// Composite
// Observer
public class Popup extends JDialog implements WindowListener {

    private InventorySelection parent;

    protected Popup(InventorySelection parent, ShoppingCart shoppingCart, ImageIcon image, Item item) {
        super(Window.getInstance(), item.getItemName());
        this.parent = parent;

        setLayout(new GridBagLayout());
        setSize(350, 400);

        Description descriptionComp = new Description(item.getItemDescription());
        Picture picture = new Picture(image);
        Stats stats = new Stats(item.getSalePriceAsDouble(), item.getQuantity());
        Quantity quantity = new Quantity(item.getQuantity(), stats);
        AddToCart addToCart = new AddToCart(this, shoppingCart, quantity, item);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(picture);
        content.add(Box.createVerticalStrut(20));
        content.add(descriptionComp);
        content.add(Box.createVerticalStrut(30));
        content.add(stats);
        content.add(Box.createVerticalStrut(20));
        content.add(quantity);
        content.add(Box.createVerticalStrut(20));
        content.add(addToCart);
        content.add(Box.createVerticalStrut(10));

        add(content, new GridBagConstraints());
        setLocationRelativeTo(Window.getInstance());
        addWindowListener(this);
        setVisible(true);
    }

    public void close() {
        dispose();
        parent.popupClosed();
    }

    public void windowOpened(WindowEvent e) {}

    public void windowClosing(WindowEvent e) {
        parent.popupClosed();
    }

    public void windowClosed(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}

}
