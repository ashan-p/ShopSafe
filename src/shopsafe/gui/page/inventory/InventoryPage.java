package shopsafe.gui.page.inventory;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import shopsafe.Login;
import shopsafe.ShoppingCart;
import shopsafe.User;
import shopsafe.gui.Window;

/**
 * The inventory page allows the customer to view what items are available in the inventory.
 * They can make their selection to add to the shopping cart, then proceed to the shopping cart
 * page.
 * 
 * @author Ashan Perera
 */
public class InventoryPage extends JPanel {

    public InventoryPage(User user, ShoppingCart shoppingCart) {
        ViewCart viewCart = new ViewCart(user, shoppingCart);
        InventorySelection inventorySelection = new InventorySelection(shoppingCart);

        setLayout(new BorderLayout());

        add(viewCart, BorderLayout.PAGE_START);
        add(inventorySelection, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Login database = Login.getInstance();
        User user = database.login("Abc", "def");

        ShoppingCart shoppingCart = new ShoppingCart(user);

        Window.getInstance().start();
        Window.getInstance().gotoInventory(user, shoppingCart);
    }
    
}
