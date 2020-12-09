package shopsafe.gui.page.inventory;

import javax.swing.JLabel;
import javax.swing.JTextArea;

// Decorator
public class Description extends JTextArea {
    
    protected Description (String description) {
        super(0, 20);

        setText(description);
        setWrapStyleWord(true);
        setLineWrap(true);
        setOpaque(false);
        setEditable(false);
        setFocusable(false);
        setAlignmentX(JLabel.CENTER_ALIGNMENT);
    }

}
