package shopsafe.gui.page.login;

import java.awt.Color;

import javax.swing.JLabel;

// Decorator
// Observer
public class SubmitError extends JLabel {

    public static enum Type {
        NoUsername,
        NoPassword,
        InvalidLogin,
        UsernameExists,
    }
    
    protected SubmitError() {
        setForeground(Color.RED);
    }

    public void reset() {
        setText("");
    }

    public void notify(Type type) {
        switch (type) {
            case NoUsername:
                setText("Enter username.");
                break;
            case NoPassword:
                setText("Enter password.");
                break;
            case InvalidLogin:
                setText("Invalid login.");
                break;
            case UsernameExists:
                setText("Username already exists.");
                break;
        }
    }

}