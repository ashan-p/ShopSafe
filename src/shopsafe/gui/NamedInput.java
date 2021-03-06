package shopsafe.gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;

/**
 * Combines an input field with a name. Makes use of the Composite and Template patterns.
 * @author Ashan Perera
 */
public abstract class NamedInput<E> extends JPanel {

    private JLabel name;
    
    protected NamedInput(String nameStr) {
        name = new JLabel(nameStr);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(name);
        add(createInput());
    }

    public abstract Component createInput();
    public abstract E getValue();

    /**
     * Get the name label.
     */
    protected JLabel getNameLabel() {
        return name;
    }

}
