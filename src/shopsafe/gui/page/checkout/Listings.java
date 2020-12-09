package shopsafe.gui.page.checkout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Listings extends JScrollPane {
    
    protected Listings(Object[][] listings) {
        super(new JTable(listings, new String[]{"Name", "Quantity", "Price"}));
    }

}
