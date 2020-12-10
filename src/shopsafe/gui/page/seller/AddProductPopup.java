package shopsafe.gui.page.seller;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import shopsafe.User;
import shopsafe.gui.NamedSpinner;
import shopsafe.gui.NamedTextField;
import shopsafe.gui.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class AddProductPopup extends JDialog implements WindowListener {

    private OnlyOneManager<AddProductPopup> parent;

    protected AddProductPopup(OnlyOneManager<AddProductPopup> parent, User user, InventorySelection inventorySelection) {
        super(Window.getInstance(), "Add Product");
        this.parent = parent;

        setLayout(new GridBagLayout());
        setSize(350, 400);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        NamedTextField productName = new NamedTextField("Product Name");

        NamedTextField description = new NamedTextField("Product Description");

        NamedTextField basePrice = new NamedTextField("Base Price");
        NamedTextField salePrice = new NamedTextField("Sale Price");

        NamedSpinner quantityInput = new NamedSpinner("Quantity");
        quantityInput.setInputBounds(1, 1, Integer.MAX_VALUE, 1);

        NamedTextField imagePath = new NamedTextField("Path to Product Image");

        AddProductSubmit addProductSubmit = new AddProductSubmit(this, user, inventorySelection, productName, description, basePrice, salePrice, quantityInput, imagePath);

        content.add(productName);
        content.add(Box.createVerticalStrut(10));
        content.add(description);
        content.add(Box.createVerticalStrut(10));
        content.add(basePrice);
        content.add(Box.createVerticalStrut(10));
        content.add(salePrice);
        content.add(Box.createVerticalStrut(10));
        content.add(quantityInput);
        content.add(Box.createVerticalStrut(10));
        content.add(imagePath);
        content.add(Box.createVerticalStrut(30));
        content.add(addProductSubmit);

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
