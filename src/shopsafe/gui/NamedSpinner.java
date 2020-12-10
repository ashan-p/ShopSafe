package shopsafe.gui;

import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.SpinnerNumberModel;

// Template
/**
 * @author Ashan Perera
 */
public class NamedSpinner extends NamedInput<Integer> {
    
    private JSpinner input;

    public NamedSpinner(String name) {
        super(name);
    }

    public Component createInput() {
        input = new JSpinner();
        return input;
    }

    public JSpinner getInput() {
        return input;
    }

    public Integer getValue() {
        return (Integer)input.getValue();
    }

    public void setInputBounds(int value, int minimum, int maximum, int step) {
        SpinnerNumberModel model = new SpinnerNumberModel(value, minimum, maximum, step);
        input.setModel(model);
    }

}
