package shopsafe.gui.page.cart;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Names extends JPanel {

    protected Names() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void add (String name) {
        add(new JLabel(name));
    }
    
}
