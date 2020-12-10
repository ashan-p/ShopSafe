package shopsafe.gui;

import javax.swing.JTextField;
import java.awt.Component;

// Template
/**
 * @author Ashan Perera
 */
public class NamedTextField extends NamedInput<String> {
    
    private JTextField field;

    public NamedTextField(String name) {
        super(name);
    }

    public Component createInput() {
        field = new JTextField();
        return field;
    }

    public JTextField getField() {
        return field;
    }

    public String getValue() {
        return field.getText();
    }

    public boolean empty() {
        return field.getText().length() == 0;
    }

    public void setValue(String value) {
        field.setText(value);
    }
}
