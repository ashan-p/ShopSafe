import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("ShopSafe");
        frame.setSize(600, 480);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);                              // currently resizing disabled
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel hello = new JLabel("Welcome to ShopSafe!");
        hello.setHorizontalAlignment(JLabel.CENTER);

        JLabel username_text = new JLabel("Username");
        JTextField username = new JTextField();

        JLabel password_text = new JLabel("Password");
        JPasswordField password = new JPasswordField();

        JPanel login = new JPanel(new GridLayout(2, 1));
        login.add(hello);
        login.add(username_text);
        login.add(username);
        login.add(password_text);
        login.add(password);

        frame.add(login, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
