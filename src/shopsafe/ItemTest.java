package shopsafe;

public class ItemTest {
    public static void main(String[] Args){
        //Initialize varaibles needed for testing
        User owner = new User("Owner","abc123",User.SELLER_ACCOUNT);
        User buyer = new User("Buyer","abc123",User.STANDARD_ACCOUNT);
        Item item = new Item("Red rider BB gun",10,owner);
        

        Inventory inv = Inventory.getInstance();

        //Test setters and setters
        item.setBasePrice(100);
        item.setSalePrice(1000); //What a markup!
        item.setDescription("You'll shoot your eye out!");

        assert(item.getQuantity() == 10);
        assert(100 == item.getBasePrice());
        assert(1000 == item.getSalePrice());
        assert(item.getItemDescription().equals("You'll shoot your eye out!"));
        assert(item.getItemName().equals("Red rider BB gun"));

        //Testing increment
        item.incrementQuantity();
        assert(item.getQuantity() == 11);

        

        
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

        assert(test.getQuantity() == 1);
        Item test2 = inv.getItem(item);
        assert(test2.getQuantity() == 10);
        test.putOne();
        assert(false);
        





    


    }
    
}
