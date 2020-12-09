package shopsafe.gui.page.checkout;

import javax.swing.JButton;

import shopsafe.gui.NamedTextField;
import shopsafe.gui.Window;
import shopsafe.gui.page.checkout.SubmitError.Cause;

// Observer
public class Submit extends JButton {

    protected Submit(
        Popup parent,
        SubmitError submitError,
        NamedTextField firstName,
        NamedTextField lastName,
        NamedTextField creditCardNumber,
        NamedTextField cvv,
        NamedTextField expirationDate
    ) {
        super("Submit");

        addActionListener(e -> {
            if (firstName.empty()) {
                submitError.showError(Cause.NoFirstName);
            } else if (lastName.empty()) {
                submitError.showError(Cause.NoLastName);
            } else if (creditCardNumber.empty()) {
                submitError.showError(Cause.NoCCNumber);
            } else if (cvv.empty()) {
                submitError.showError(Cause.NoCVV);
            } else if (expirationDate.empty()) {
                submitError.showError(Cause.NoExpirationDate);
            } else {
                submitError.reset();
                parent.close();
                Window.getInstance().gotoInventory(null);
            }
        });
    }

}
