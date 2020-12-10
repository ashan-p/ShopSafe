package shopsafe.gui.page.cart;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Quantities extends JPanel {
    
    protected Quantities() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public JSpinner add (int quantity, int available) {
        SpinnerNumberModel bounds = new SpinnerNumberModel(quantity, 0, available, 1);
        JSpinner input = new JSpinner(bounds);

        add(input);
        return input;
    }

}
