import java.util.ArrayList;

/**
 * A collection of Items.
 * 
 * Uses the Singleton pattern.
 */

public class Inventory extends ArrayList<Item> {
    
    private static Inventory instance = new Inventory();
    public static Inventory getInstance() { return instance; }

    private Inventory() {
        /** possibly load from a file */
    }

}