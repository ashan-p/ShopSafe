package shopsafe.gui.page.checkout;

import javax.swing.JButton;

import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.NamedTextField;
import shopsafe.gui.Window;
import shopsafe.gui.page.checkout.SubmitError.Cause;

// Observer
/**
 * Submits the payment information and will error if anything is wrong.
 * 
 * @author Ashan Perera
 */
public class Submit extends JButton {

    protected Submit(
        Popup parent,
        User user, ShoppingCart shoppingCart, SubmitError submitError,
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
                
                shoppingCart.checkout();

                Window.getInstance().gotoInventory(user, shoppingCart);
            }
        });
    }

}
