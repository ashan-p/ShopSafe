package shopsafe;

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
        /** temp code for load from a file */
        for (int i = 0; i < 30; i++) {
            Item item = new Item("abc");
            add(item);
        }
    }

}