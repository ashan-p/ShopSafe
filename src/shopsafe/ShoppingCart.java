package shopsafe;

import java.util.*;

/**
 * Provides shoping cart for session, aggregates items for purchase and creates transactions
 */
public class ShoppingCart {


    private ArrayList<Item> items;
    User owner;

    public ShoppingCart(User u){
        items = new ArrayList<Item>();
        this.owner = u;
    }

    /**
     * 
     * @param i Item to add to cart
     * @throws RuntimeException
     */
    public void addItem(Item i) throws RuntimeException{
        if(i.getQuantity() <= 0){
            throw new RuntimeException("Not enough item to add");            
        }
        else{
            items.add(i.getOne());
        }
    }

    /**
     * Removes an item from the cart
     * @param i Item to remove
     */
    public void removeItem(Item i){
        i.putOne();
        items.remove(i);
    }
    /**
     * 
     * @return # items in cart
     */
    public int size(){
        return items.size();
    }
    /**
     * Returns a collection of items in the cart
     * @return An array list of the items in the shopping cart
     */
    public ArrayList<Item> getItems(){
        ArrayList<Item> retval = new ArrayList<Item>();
        for(Item i : items){
            retval.add(i);
        }

        return retval;
    }

    //Destructor for shopping cart to re-add all items to inventory
    public void clear(){
    for(Item i : items){
        i.putOne();
    }
    items.clear();
    }

    /**
     * Completes all the processes required for buying the items.
     */
    public void checkout(){
        Transaction t1;
        Transaction t2;
        //Create transactions for each item in the cart and add them to the log/user accounts
        TransactionLog log = TransactionLog.getInstance();
        for(Item i : items){
            t1 = new Transaction(i.getOwner(), owner, i);
            t2 = new Transaction(i.getOwner(),owner,i);
            //Add the transactions to the users, and the log
            log.add(t1);
            owner.addTransaction(t2);
            i.getOwner().addTransaction(t2);
        }
        //Save the log and the inventory and the login
        log.save();
        Inventory.getInstance().save();
        Login.getInstance().save();
        //Clear the items in the cart
        items.clear();

    }

}
