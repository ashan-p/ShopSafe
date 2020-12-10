package shopsafe.gui.page.login;

import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 * The Authorization options for choosing between logging in or signing up.
 * Makes use of the Composite and Observer patterns.
 * 
 * @author Ashan Perera
 */
public class AuthOptions extends ButtonGroup {

    private JRadioButton login;
    private JRadioButton signUp;

    protected AuthOptions (SignUpOptions signUpOptions, SubmitError submitError) {
        login = new JRadioButton("Login", true);
        signUp = new JRadioButton("Sign Up");

        login.addActionListener(e -> {
            signUpOptions.notify(false);
            submitError.reset();
        });
        signUp.addActionListener(e -> {
            signUpOptions.notify(true);
            submitError.reset();
        });
        
        add(login);
        add(signUp);
    }

    /**
     * Adds the buttons to the specified container.
     */
    public void addButtons (Container container) {
        container.add(login);
        container.add(signUp);
    }

    /**
     * Gets the selected authorization type.
     */
    public AuthType getSelectedOption() {
        if (login.isSelected()) {
            return AuthType.Login;
        } else {
            return AuthType.SignUp;
        }
    }
    
}
