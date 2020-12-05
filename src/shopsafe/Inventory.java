package shopsafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

/**
 * A collection of Items.
 * 
 * Uses the Singleton pattern.
 */

/*
Daniel : I dropped the extension of the array list class, because I want to load it from a file internally, and the this pointer is immutable so
it needed to be done this way AFAIK */
public class Inventory{
    
    private static Inventory instance = new Inventory();
    public static Inventory getInstance() { return instance; }
    HashMap<String,Item> items;

    private Inventory() {
        try{
            FileInputStream fileIn = new FileInputStream("inventory.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            items = (HashMap<String,Item>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (Exception e){
            items = new HashMap<String,Item>();
        }

    }

    public void addItem(Item i) throws RuntimeException{
        //Check if the item already exists
        String itemName = i.getItemName();
        
        //If item exists throw exception
        if(items.get(itemName) != null){
            throw new RuntimeException("Item already exists");
        }

        //If item does not exist add it
        else{
            items.put(itemName,i);
        }
    }

    public void removeItem(Item i) throws RuntimeException
    {
        if(items.get(i.getItemName()) == null){
            throw new RuntimeException("Item does not exist");
        }
        else{
            items.remove(i.getItemName());
        }  
    
    }

    public int getSize(){
        return items.size();
    }

    /**
     * Gets the first n items in the inventory
     * @param n
     * @return first n items in inventory in an ArrayList<Item>
     */
    public ArrayList<Item> getItems(int n) throws RuntimeException{
        int size = items.size();
        int i = 1;
        ArrayList<Item> retval = new ArrayList<Item>();
        if(n > size){
            throw new RuntimeException("Illegal Argument n must be < size");
        }
        else{
            for(String p : items.keySet()){
                retval.add(items.get(p));
                if(i == n){
                    break;
                }
                i++;
            }
        }
        return retval;
    }

    public boolean save(){
        try {
            FileOutputStream fileOut =
            new FileOutputStream("inventory.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(items);
            out.close();
            fileOut.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    //Test Function
    public static void main(String[] Args){
        User u = new User("Daniel","12345",User.STANDARD_ACCOUNT);
        
        Item i = new Item("Televsion",10,u);
        Inventory inv = Inventory.getInstance();
        inv.removeItem(i);
        inv.save();


        
        
            
        

        

        



    }



    

    

}