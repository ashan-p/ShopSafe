package shopsafe.gui.page.login;

import javax.swing.JButton;

import shopsafe.Login;
import shopsafe.User;
import shopsafe.gui.Window;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Submit extends JButton implements ActionListener {
    
    private Username username;
    private Password password;
    private AuthOptions authOptions;
    private SignUpOptions signUpOptions;
    private SubmitError submitError;

    protected Submit(
        Username username,
        Password password,
        AuthOptions authOptions,
        SignUpOptions signUpOptions,
        SubmitError submitError
    ) {
        super("Submit");

        this.username = username;
        this.password = password;
        this.authOptions = authOptions;
        this.signUpOptions = signUpOptions;
        this.submitError = submitError;

        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Window window = Window.getInstance();
        Login database = Login.getInstance();

        if (username.empty()) {
            submitError.notify(SubmitError.Type.NoUsername);
        } else if (password.empty()) {
            submitError.notify(SubmitError.Type.NoPassword);
        } else {
            String un = username.getValue();
            String pw = password.getValue();
            switch (authOptions.getSelectedOption()) {
                case Login: {
                    User user = database.login(un, pw);
                    if (user == null) {
                        submitError.setText("Invalid login.");
                    } else {
                        window.gotoInventory(user);
                    }
                }
                case SignUp: {
                    int acc;
                    switch (signUpOptions.getSelectedOption()) {
                        case Seller:
                            acc = User.SELLER_ACCOUNT;
                            break;
                        default: // Customer
                            acc = User.STANDARD_ACCOUNT;
                            break;
                    }

                    try {
                        User user = database.signUp(un, pw, acc);
                        window.gotoInventory(user);
                    } catch (Login.UsernameExists ex) {
                        submitError.notify(SubmitError.Type.UsernameExists);
                    }
                }
            }
        }
    }
}
