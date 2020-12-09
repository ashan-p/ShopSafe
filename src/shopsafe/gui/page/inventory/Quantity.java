package shopsafe.gui.page.inventory;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import shopsafe.gui.NamedInput;

// Template
// Observer
public class Quantity extends NamedInput<Integer> {

    private JSpinner input;

    protected Quantity(int available, Stats stats) {
        super("Quantity");

        getNameLabel().setAlignmentX(JLabel.CENTER_ALIGNMENT);

        SpinnerModel bounds = new SpinnerNumberModel(1, 1, available, 1);
        input.setModel(bounds);
        input.addChangeListener(e -> stats.setQuantity(getValue()));
    }

    public Component createInput() {
        input = new JSpinner();
        return input;
    }

    public Integer getValue() {
        return (Integer)input.getValue();
    }
    
}
