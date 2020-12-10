package shopsafe.gui.page.seller;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import shopsafe.Login;
import shopsafe.User;
import shopsafe.gui.Window;

public class SellerPage extends JPanel {
    
    public SellerPage(User user) {
        setLayout(new BorderLayout());

        Logout logout = new Logout();
        InventorySelection inventorySelection = new InventorySelection();

        OnlyOneManager<AddProductPopup> popupManager = new OnlyOneManager<>();
        AddProduct addProduct = new AddProduct(popupManager, user, inventorySelection);

        add(logout, BorderLayout.PAGE_START);
        add(inventorySelection, BorderLayout.CENTER);
        add(addProduct, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        Login database = Login.getInstance();
        User user = database.login("Abcd", "edfg");

        Window.getInstance().start();
        Window.getInstance().gotoSeller(user);
    }

}
