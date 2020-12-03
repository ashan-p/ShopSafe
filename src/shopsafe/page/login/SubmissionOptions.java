package shopsafe.page.login;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class SubmissionOptions extends ButtonGroup {

    private JRadioButton login;
    private JRadioButton signUp;

    protected SubmissionOptions () {
        login = new JRadioButton("Login", true);
        signUp = new JRadioButton("Sign Up");
        
        add(login);
        add(signUp);
    }
    
}
