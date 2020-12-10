package shopsafe;

import org.junit.*;
import static org.junit.Assert.*;


//Note Daniel : JUnit testing isnt working for me within VSCODE so I'm using system out and manually inspecting the outputs for testing purposes

/**
 * @author : Daniel Bennett
 */
public class ItemTest {
    
    public static void main(String args[]){
        //Initialize varaibles needed for testing
        User owner = new User("Owner","abc123",User.SELLER_ACCOUNT);
        User buyer = new User("Buyer","abc123",User.STANDARD_ACCOUNT);
        Item item = new Item("Red rider BB gun",10,owner);
        

        Inventory inv = Inventory.getInstance();

        //Test setters and setters
        item.setBasePrice(100);
        item.setSalePrice(999); //What a markup!
        item.setDescription("You'll shoot your eye out!");

        System.out.println(item.getBasePrice());
        System.out.println(item.getSalePrice());
        System.out.println(item.getItemDescription());

        //assert(item.getQuantity() == 10);
        //assert(100 == item.getBasePrice());
        //assert(1000 == item.getSalePrice());
        //assert(item.getItemDescription().equals("You'll shoot your eye out!"));
        //assert(item.getItemName().equals("Red rider BB gun"));

        //Testing string parsing
        item.setSalePrice("109.997");
        item.setBasePrice("12.21");

        System.out.println(item.getSalePrice());
        System.out.println(item.getBasePrice());


        //Testing increment
        item.incrementQuantity();
        //assert(item.getQuantity() == 11);
        System.out.println(item.getQuantity());
        
        //Setup for testing of cart functionm

        try{
            inv.removeItem(item);
        }
        catch(Exception e){
            //Don't need to recover here
        }
        inv.addItem(item);
        inv.save();

        Item test = item.getOne();

        System.out.println(test.getQuantity());

        
        Item test2 = inv.getItem(item);
        //assert(test2.getQuantity() == 10);
        System.out.println(test2.getQuantity());
        //test.putOne();
        





    


    }
    
}
