package shopsafe.gui;

import javax.swing.JTextField;
import java.awt.Component;

/**
 * Creates a Named Input with a JTextField. Makes use of Template pattern.
 * @author Ashan Perera
 */
public class NamedTextField extends NamedInput<String> {
    
    private JTextField field;

    /**
     * Creates with a new name.
     */
    public NamedTextField(String name) {
        super(name);
    }

    /**
     * Creates a text field.
     */
    public Component createInput() {
        field = new JTextField();
        return field;
    }

    /**
     * Returns the text field.
     */
    public JTextField getField() {
        return field;
    }

    /**
     * Gets the text field value.
     */
    public String getValue() {
        return field.getText();
    }

    /**
     * Checks if the input is empty.
     */
    public boolean empty() {
        return field.getText().length() == 0;
    }

    /**
     * Sets the text field value.
     */
    public void setValue(String value) {
        field.setText(value);
    }
}
