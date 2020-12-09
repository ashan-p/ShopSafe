package shopsafe.gui.page.login;

import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

// Composite
// Observer
// MVC
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

    public void addButtons (Container container) {
        container.add(login);
        container.add(signUp);
    }

    public AuthType getSelectedOption() {
        if (login.isSelected()) {
            return AuthType.Login;
        } else {
            return AuthType.SignUp;
        }
    }
    
}
