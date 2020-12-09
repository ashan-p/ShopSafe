package shopsafe.gui.page.login;

import java.awt.Component;

import javax.swing.JPasswordField;

import shopsafe.gui.NamedInput;

// Template
public class Password extends NamedInput<String> {

    private JPasswordField field;

    protected Password() {
        super("Password");
    }

    public Component createInput() {
        field = new JPasswordField();
        return field;
    }

    public String getValue() {
        return new String(field.getPassword());
    }

    public boolean empty() {
        return field.getPassword().length == 0;
    }
}