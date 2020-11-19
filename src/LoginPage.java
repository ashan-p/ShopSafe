import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

/**
 * The LoginPage handles logging the user into the system. It should be the first page
 * the user sees when first opening the application. The user can enter their username and
 * password here to access their Customer or Seller account.
 */
public class LoginPage extends JPanel {
    
    /**
     * Creates a new LoginPage. Sets up a title, input for the username and password,
     * and a button for submitting the information.
     */
    public LoginPage () {

        JLabel hello = new JLabel("Welcome to ShopSafe!");
        hello.setHorizontalAlignment(JLabel.CENTER);

        JLabel username_text = new JLabel("Username");
        JTextField username = new JTextField();

        JLabel password_text = new JLabel("Password");
        JPasswordField password = new JPasswordField();

        JButton submit = new JButton("Submit");
        submit.addActionListener(event -> {
            System.out.println("Username: " + username.getText());
            System.out.println("Password: " + new String(password.getPassword()));
        });

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(hello);
        content.add(Box.createVerticalStrut(60));
        content.add(username_text);
        content.add(username);
        content.add(Box.createVerticalStrut(10));
        content.add(password_text);
        content.add(password);
        content.add(Box.createVerticalStrut(10));
        content.add(submit);

        setLayout(new GridBagLayout());
        add(content, new GridBagConstraints());

    }

}
