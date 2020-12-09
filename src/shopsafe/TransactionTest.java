package shopsafe;

public class TransactionTest {
    public static void main(String[] args){

        //Initialize varaibles needed for testing
        User owner = new User("Owner","abc123",User.SELLER_ACCOUNT);
        User buyer = new User("Buyer","abc123",User.STANDARD_ACCOUNT);
        Item item = new Item("Red rider BB gun",2,owner);
        item.setBasePrice(100);
        item.setSalePrice(1000); //What a markup!

        Transaction t = new Transaction(owner,buyer,item);

        //Testing getters
        System.out.println("Testing getters");

        assert(t.getBasePrice() == item.getBasePrice());
        assert(t.getSalePrice() == item.getSalePrice());
        assert(owner.equals(t.getSeller()));
        assert(buyer.equals(t.getPurchaser()));
        assert(t.getProfit() == 900);
        assert(t.getItemName().equals(item.getItemName()));

        System.out.println("PASSED");




               
        


    }
}
