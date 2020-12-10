package shopsafe.gui.page.inventory;

import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Decorator
// Observer
/**
 * Shows the price and available amount of the item, and updates the
 * price based on quantity. Makes use of the Decorator and Observer patterns.
 * 
 * @author Ashan Perera
 */
public class Stats extends JPanel {

    private double price;
    private JLabel priceLabel;

    protected Stats(double price, double available) {
        this.price = price;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel availableLabel = new JLabel("Available: " + available);
        availableLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        priceLabel = new JLabel();
        priceLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        add(availableLabel);
        add(priceLabel);

        setQuantity(1);
    }

    public void setQuantity (int quantity) {
        double totalPrice =  price * quantity;
        String formattedPrice = NumberFormat.getCurrencyInstance().format(totalPrice);
        priceLabel.setText("Total price: " + formattedPrice);
    }
    
}
