package shopsafe.gui.page.login;

import javax.swing.JComboBox;

// uses Observer pattern, Adapter pattern
public class SignUpOptions extends JComboBox<SignUpType> {

    protected SignUpOptions() {
        super(new SignUpType[]{
            SignUpType.Customer,
            SignUpType.Seller
        });

        setEnabled(false);
        setAlignmentX(0.0f);
    }

    public void notify (boolean state) {
        setEnabled(state);
    }

    public SignUpType getSelectedOption() {
        return (SignUpType)getSelectedItem();
    }

}
