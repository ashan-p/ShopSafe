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
        //TODO: find a better way to mangage items
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

    //TODO : FINISH THIS
    public void checkout(){
        //TODO Create transactions for every item in the cart;
        //ADD TRANSACTION TO LOG
        //ADD TRANSACTION TO SELLER/AND USERS


    }

}
