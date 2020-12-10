package shopsafe.gui.page.checkout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * The listings show a table of all items in the cart,
 * with their name, quantity, and price. Makes use of
 * the Decorator pattern.
 * 
 * @author Ashan Perera
 */
public class Listings extends JScrollPane {
    
    protected Listings(Object[][] listings) {
        super(new JTable(listings, new String[]{"Name", "Quantity", "Price"}));
    }

}
