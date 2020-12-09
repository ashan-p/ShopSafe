package shopsafe.gui.page.login;

import java.awt.Component;

import javax.swing.JTextField;

import shopsafe.gui.NamedInput;

// Template
public class Username extends NamedInput<String> {

    private JTextField field;

    protected Username() {
        super("Username");
    }

    public Component createInput() {
        field = new JTextField();
        return field;
    }

    public String getValue() {
        return field.getText();
    }

    public boolean empty() {
        return field.getText().length() == 0;
    }
}
