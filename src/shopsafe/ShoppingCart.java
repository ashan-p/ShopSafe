package shopsafe;

import java.util.*;


public class ShoppingCart {


    private ArrayList<Item> items;
    User owner;

    public ShoppingCart(User u){
        items = new ArrayList<Item>();
        this.owner = u;
    }

    public void addItem(Item i) throws RuntimeException{
        if(i.getQuantity() <= 0){
            throw new RuntimeException("Not enough item to add");            
        }
        else{
            items.add(i.getOne());
        }
    }

    public void removeItem(Item i){
        i.putOne();
        items.remove(i);
    }

    public int size(){
        return items.size();
    }

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
