package shopsafe.gui.page.checkout;

import java.awt.Color;

import javax.swing.JLabel;

public class SubmitError extends JLabel {
    
    public static enum Cause {
        NoFirstName,
        NoLastName,
        NoCCNumber,
        NoCVV,
        NoExpirationDate,
    }

    protected SubmitError() {
        setForeground(Color.RED);
    }

    public void reset() {
        setText("");
    }

    public void showError(Cause cause) {
        switch (cause) {
            case NoFirstName:
                setText("Enter first name.");
                break;
            case NoLastName:
                setText("Enter last name.");
                break;
            case NoCCNumber:
                setText("Enter credit card number.");
                break;
            case NoCVV:
                setText("Enter CVV.");
                break;
            case NoExpirationDate:
                setText("Enter expiration date.");
                break;
        }
    }

}
