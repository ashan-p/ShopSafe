package shopsafe.page.login;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import shopsafe.Login;
import shopsafe.User;
import shopsafe.Window;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

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
        Window window = Window.getInstance();
        Login database = Login.getInstance();

        JLabel welcome = new JLabel("Welcome to ShopSafe!");
        JComboBox<String> signUpOptions = new JComboBox<String>(new String[]{
            "Customer",
            "Seller",
        });
        signUpOptions.setEnabled(false);
        signUpOptions.setAlignmentX(0.0f);

        JRadioButton login = new JRadioButton("Login", true);
        JRadioButton signUp = new JRadioButton("Sign Up");

        ButtonGroup submissionOptions = new ButtonGroup();
        submissionOptions.add(login);
        submissionOptions.add(signUp);

        JLabel username_text = new JLabel("Username");
        JTextField username = new JTextField();

        JLabel password_text = new JLabel("Password");
        JPasswordField password = new JPasswordField();

        JLabel submitError = new JLabel();
        submitError.setForeground(Color.RED);

        login.addActionListener(e -> {
            signUpOptions.setEnabled(false);
            submitError.setText("");
        });
        signUp.addActionListener(e -> {
            signUpOptions.setEnabled(true);
            submitError.setText("");
        });

        JButton submit = new JButton("Submit");
        submit.addActionListener(event -> {
            String un = username.getText();
            String pw = new String(password.getPassword());

            if (un.length() == 0) {
                submitError.setText("Enter username.");
            } else if (pw.length() == 0) {
                submitError.setText("Enter password.");
            } else {
                if (login.isSelected()) {
                    User user = database.login(un, pw);
                    if (user == null) {
                        submitError.setText("Invalid login.");
                    } else {
                        window.gotoInventory(user);
                    }
                } else {
                    int acc;
                    if (((String)signUpOptions.getSelectedItem()).equals("Customer")) {
                        acc = User.STANDARD_ACCOUNT;
                    } else {
                        acc = User.SELLER_ACCOUNT;
                    }

                    try {
                        User user = database.signUp(un, pw, acc);
                        window.gotoInventory(user);
                    } catch (Login.UsernameExists ex) {
                        submitError.setText("Username already exists.");
                    }
                }
            }
        });

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(welcome);
        content.add(Box.createVerticalStrut(30));
        content.add(login);
        content.add(signUp);
        content.add(Box.createVerticalStrut(20));
        content.add(username_text);
        content.add(username);
        content.add(Box.createVerticalStrut(10));
        content.add(password_text);
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
