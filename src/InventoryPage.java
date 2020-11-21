import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class InventoryPage extends JPanel {
    
    public InventoryPage(User user) {
        setLayout(new GridBagLayout());
        add(new JLabel("A lonely inventory for " + user.getUserName() + "..."), new GridBagConstraints());
    }

}
