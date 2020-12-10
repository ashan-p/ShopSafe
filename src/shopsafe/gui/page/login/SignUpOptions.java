package shopsafe.gui.page.login;

import javax.swing.JComboBox;

/**
 * Signing up options for determining if making a Customer or
 * Seller account. Uses the Observer and Adapter patterns.
 * 
 * @author Ashan Perera
 */
public class SignUpOptions extends JComboBox<SignUpType> {

    protected SignUpOptions() {
        super(new SignUpType[]{
            SignUpType.Customer,
            SignUpType.Seller
        });

        setEnabled(false);
        setAlignmentX(0.0f);
    }

    /**
     * Enables allowing user input based on state.
     */
    public void notify (boolean state) {
        setEnabled(state);
    }

    /**
     * Gets the selected option.
     */
    public SignUpType getSelectedOption() {
        return (SignUpType)getSelectedItem();
    }

}
