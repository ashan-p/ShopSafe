package shopsafe.gui;

import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.SpinnerNumberModel;

/**
 * Creates a Named Input with a JSpinner. Makes use of Template pattern.
 * @author Ashan Perera
 */
public class NamedSpinner extends NamedInput<Integer> {
    
    private JSpinner input;

    public NamedSpinner(String name) {
        super(name);
    }

    /**
     * Creates a new JSpinner.
     */
    public Component createInput() {
        input = new JSpinner();
        return input;
    }

    /**
     * Returns the input.
     */
    public JSpinner getInput() {
        return input;
    }

    /**
     * Gets the spinner integer value.
     */
    public Integer getValue() {
        return (Integer)input.getValue();
    }

    /**
     * Sets the bound of the spinner input.
     */
    public void setInputBounds(int value, int minimum, int maximum, int step) {
        SpinnerNumberModel model = new SpinnerNumberModel(value, minimum, maximum, step);
        input.setModel(model);
    }

}
