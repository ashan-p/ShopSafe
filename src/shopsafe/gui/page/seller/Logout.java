package shopsafe.gui.page.seller;

import javax.swing.JButton;

import shopsafe.gui.Window;

public class Logout extends JButton {
    
    protected Logout() {
        super("Log out");

        addActionListener(e -> Window.getInstance().gotoLogin());
    }

}
