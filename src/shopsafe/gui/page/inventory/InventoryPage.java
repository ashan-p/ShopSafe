package shopsafe.gui.page.inventory;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import shopsafe.gui.Window;

public class InventoryPage extends JPanel {

    public InventoryPage() {
        ViewCart viewCart = new ViewCart();
        InventorySelection inventorySelection = new InventorySelection();

        setLayout(new BorderLayout());

        add(viewCart, BorderLayout.PAGE_START);
        add(inventorySelection, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Window.getInstance().start();
        Window.getInstance().gotoInventory(null);
    }
    
}
