package shopsafe.gui.page.seller;

import shopsafe.Item;
import shopsafe.gui.NamedSpinner;
import shopsafe.gui.NamedTextField;
import shopsafe.gui.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ViewProductPopup extends JDialog implements WindowListener {
    
    private OnlyOneManager<ViewProductPopup> parent;

    protected ViewProductPopup(OnlyOneManager<ViewProductPopup> parent, InventorySelection inventorySelection, ImageIcon image, Item item) {
        super(Window.getInstance(), item.getItemName());
        this.parent = parent;

        setLayout(new GridBagLayout());
        setSize(350, 400);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(image);

        NamedTextField descriptionInput = new NamedTextField("Description");
        descriptionInput.setValue(item.getItemDescription());

        NamedTextField basePriceInput = new NamedTextField("Base Price");
        basePriceInput.setValue(String.valueOf(item.getBasePriceAsDouble()));

        NamedTextField salePriceInput = new NamedTextField("Sale Price");
        salePriceInput.setValue(String.valueOf(item.getSalePriceAsDouble()));

        NamedSpinner quantityInput = new NamedSpinner("Quantity");
        quantityInput.setInputBounds(item.getQuantity(), 1, Integer.MAX_VALUE, 1);

        NamedTextField imagePathInput = new NamedTextField("Path to Product Image");
        imagePathInput.setValue(item.getImagePath());

        JPanel options = new JPanel();
        options.setLayout(new BoxLayout(options, BoxLayout.X_AXIS));
        options.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        ViewProductSave productSave = new ViewProductSave(this, inventorySelection, item, descriptionInput, basePriceInput, salePriceInput, quantityInput, imagePathInput);
        DeleteProduct deleteProduct = new DeleteProduct(this, inventorySelection, item);

        options.add(deleteProduct);
        options.add(Box.createHorizontalStrut(40));
        options.add(productSave);

        content.add(imageLabel);
        content.add(Box.createVerticalStrut(10));
        content.add(descriptionInput);
        content.add(Box.createVerticalStrut(10));
        content.add(basePriceInput);
        content.add(Box.createVerticalStrut(10));
        content.add(salePriceInput);
        content.add(Box.createVerticalStrut(10));
        content.add(quantityInput);
        content.add(Box.createVerticalStrut(10));
        content.add(imagePathInput);
        content.add(Box.createVerticalStrut(30));
        content.add(options);

        add(content, new GridBagConstraints());
        setLocationRelativeTo(Window.getInstance());
        addWindowListener(this);
        setVisible(true);
    }

    public void close() {
        dispose();
        parent.reset();
    }

    public void windowOpened(WindowEvent e) {}

    public void windowClosing(WindowEvent e) {
        parent.reset();
    }

    public void windowClosed(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}

}
