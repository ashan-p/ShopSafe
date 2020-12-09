package shopsafe.gui.page.seller;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

import shopsafe.gui.NamedTextField;
import shopsafe.gui.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class AddProductPopup extends JDialog implements WindowListener {

    private OnlyOneManager<AddProductPopup> parent;

    protected AddProductPopup(OnlyOneManager<AddProductPopup> parent) {
        super(Window.getInstance(), "Add Product");
        this.parent = parent;

        setLayout(new GridBagLayout());
        setSize(350, 400);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        NamedTextField productName = new NamedTextField("Product name");
        //NamedTextField 

        NamedTextField firstName = new NamedTextField("First Name");
        NamedTextField lastName = new NamedTextField("Last Name");
        NamedTextField creditCardNumber = new NamedTextField("Credit Card Number");
        NamedTextField cvv = new NamedTextField("CVV");
        NamedTextField expirationDate = new NamedTextField("Expiration Date");

        content.add(firstName);
        content.add(Box.createVerticalStrut(10));
        content.add(lastName);
        content.add(Box.createVerticalStrut(10));
        content.add(creditCardNumber);
        content.add(Box.createVerticalStrut(10));
        content.add(cvv);
        content.add(Box.createVerticalStrut(10));
        content.add(expirationDate);

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
