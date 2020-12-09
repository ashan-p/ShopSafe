package shopsafe.gui.page.seller;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import shopsafe.gui.Window;

public class SellerPage extends JPanel {
    
    public SellerPage() {
        setLayout(new BorderLayout());

        OnlyOneManager<AddProductPopup> addProductManager = new OnlyOneManager<>();
        AddProduct addProduct = new AddProduct(addProductManager);

        //add(viewCart, BorderLayout.PAGE_START);
        add(addProduct, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        Window.getInstance().start();
        Window.getInstance().gotoSeller();
    }

}
