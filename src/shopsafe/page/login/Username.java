package shopsafe.page.login;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * TODO: Use template pattern for Username and Password?
 */
public class Username extends JPanel {

    private JLabel label;
    private JTextField field;
    
    protected Username() {
        label = new JLabel("Username");
        field = new JTextField();
    }

}
