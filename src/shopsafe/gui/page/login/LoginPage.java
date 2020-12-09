package shopsafe.gui.page.login;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        JLabel welcome = new JLabel("Welcome to ShopSafe!");
        
        SignUpOptions signUpOptions = new SignUpOptions();
        SubmitError submitError = new SubmitError();
        Username username = new Username();
        Password password = new Password();

        AuthOptions authOptions = new AuthOptions(signUpOptions, submitError);
        Submit submit = new Submit(username, password, authOptions, signUpOptions, submitError);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(welcome);
        content.add(Box.createVerticalStrut(30));
        authOptions.addButtons(content);
        content.add(Box.createVerticalStrut(20));
        content.add(username);
        content.add(Box.createVerticalStrut(10));
        content.add(password);
        content.add(Box.createVerticalStrut(20));
        content.add(signUpOptions);
        content.add(Box.createVerticalStrut(30));
        content.add(submit);
        content.add(Box.createVerticalStrut(30));
        content.add(submitError);
        content.add(Box.createVerticalStrut(30));

        setLayout(new GridBagLayout());
        add(content, new GridBagConstraints());
    }

}
