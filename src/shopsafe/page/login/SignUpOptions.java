package shopsafe.page.login;

import javax.swing.JComboBox;

// uses Observer pattern, Adapter pattern
public class SignUpOptions extends JComboBox<String> {
    
    protected SignUpOptions() {
        super(new String[]{
            "Customer",
            "Seller",
        });

        setEnabled(false);
        setAlignmentX(0.0f);
    }

    protected void notify (boolean state) {
        setEnabled(state);
    }

}
