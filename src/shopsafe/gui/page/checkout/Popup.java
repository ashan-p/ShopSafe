package shopsafe.gui.page.checkout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.NamedTextField;
import shopsafe.gui.Window;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

/**
 * The Popup accepts payment informatino from the user, and will show
 * an error if any fields are missing. Makes use of the Composite pattern.
 * 
 * @author Ashan Perera
 */
public class Popup extends JDialog implements WindowListener {
    
    private Footer parent;

    protected Popup(Footer parent, User user, ShoppingCart shoppingCart) {
        super(Window.getInstance(), "Purchase");
        this.parent = parent;

        setLayout(new GridBagLayout());
        setSize(350, 400);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        NamedTextField firstName = new NamedTextField("First Name");
        NamedTextField lastName = new NamedTextField("Last Name");
        NamedTextField creditCardNumber = new NamedTextField("Credit Card Number");
        NamedTextField cvv = new NamedTextField("CVV");
        NamedTextField expirationDate = new NamedTextField("Expiration Date");

        SubmitError submitError = new SubmitError();

        Submit submit = new Submit(this, user, shoppingCart, submitError, firstName, lastName, creditCardNumber, cvv, expirationDate);

        content.add(firstName);
        content.add(Box.createVerticalStrut(10));
        content.add(lastName);
        content.add(Box.createVerticalStrut(10));
        content.add(creditCardNumber);
        content.add(Box.createVerticalStrut(10));
        content.add(cvv);
        content.add(Box.createVerticalStrut(10));
        content.add(expirationDate);
        content.add(Box.createVerticalStrut(30));
        content.add(submit);
        content.add(Box.createVerticalStrut(30));
        content.add(submitError);

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
