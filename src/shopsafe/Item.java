package shopsafe;

import java.math.BigDecimal;
import java.math.RoundingMode;;

/**
 * Item class holds information about an item. 
 *
 * @author Daniel Bennett
 * @version (a version number or a date)
 */
public class Item implements Cloneable, java.io.Serializable
{
    String itemName;
    String itemDescription;
    String imagePath;
    int basePrice; //Price in cents
    int salePrice;
    int quantity;
    User owner;

    
    /**
     * 
     * @param in Item name
     * @param q Quantity
     * @param o Owner of the item
     * @throws RuntimeException
     */
    public Item(String in,int q,User o) throws RuntimeException 
       {
		if(q <= 0){
            throw new RuntimeException("Quantity must be >0");
        }
        this.itemName = in;
        this.quantity = q;
        this.owner = o;
    }
    
    public void setDescription(String d){
        this.itemDescription = d;
    }

    public void setImagePath(String s){
        this.imagePath = s;
    }

    public String getImagePath(){
        return imagePath;
    }

    public int getQuantity(){
        return quantity;
    }

    public User getOwner(){
        return owner;
    }
    
    public void setSalePrice(int n){
        this.salePrice = n;
    }

    public void setSalePrice(String s) throws RuntimeException{
        BigDecimal bd = new BigDecimal(s);
        bd.setScale(2,RoundingMode.HALF_DOWN);
        bd = bd.movePointRight(2);
        this.salePrice = bd.intValue();
    }

    public void setBasePrice(String s) throws RuntimeException{
        BigDecimal bd = new BigDecimal(s);
        bd.setScale(2,RoundingMode.HALF_DOWN);
        bd = bd.movePointRight(2);
        this.basePrice = bd.intValue();

    }
    
    public void setBasePrice(int n){
        this.basePrice = n;
    }
    
    public String getItemDescription(){
        return this.itemDescription;
    }
    
    public String getItemName(){
        return this.itemName;
    }
    
    public int getSalePrice(){
        return this.salePrice;
    }
    
    public int getBasePrice(){
        return this.basePrice;
    }
    
    @Override
    public Item clone() throws CloneNotSupportedException{
        return (Item)super.clone();
    }


    /**
     * Method for getting one item for use in shopping cart, in hindsight these methods should have belong to inventory
     * @return A single Item for use in the shopping cart
     * @throws RuntimeException
     * 
     */
    public Item getOne() throws RuntimeException{
        Item i = null;
        try{
            i = this.clone();
        }catch(Exception e){
            System.out.println("Clone not supported?");
            e.printStackTrace();
        }
        if(quantity <= 0){
            throw new RuntimeException("NOT ENOUGH INVENTORY TO TAKE ITEM");
        }
        else{
            quantity--;
            i.quantity = 1;
            if(quantity == 0){
                Inventory inv = Inventory.getInstance();
                inv.removeItem(i);

            }
            return i;
        }

    }


    /**
     * Method adds one of itself to the inventory
     * @throws RuntimeException
     */
    public void putOne() throws RuntimeException{
        Item item = null;
        try{
            item = this.clone();
        }catch(Exception e){
            System.out.println("Clone Not Supported");
            e.printStackTrace();
        }
        //Check to see how many are in inventory
        Inventory inv = Inventory.getInstance();
        Item check = inv.getItem(item);
        //Case : NONE IN INVENTORY
        if(check == null){
            //Case add the item back to inventory
            item.quantity = 1;
            inv.addItem(item);
        }
        //Case : Some In Inventory
        else{
            //Adjust quantity by one
            Item fix = inv.getItem(item);
            fix.incrementQuantity();
        }

        

    }
    
    /**
     * Increments the quantity of an object by one
     */
    public void incrementQuantity(){
        quantity++;
    }

}



    
    
    


