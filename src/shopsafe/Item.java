package shopsafe;

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
    int basePrice; //Price in cents
    int salePrice;
    int quantity;
    User owner;
    

    public Item(String in,int q,User o) throws RuntimeException 
       {
		if(q <= 0){
            throw new RuntimeException("Quantity must be >0");
        }
        this.itemName = in;
        this.quantity = q;
        this.owner = o;
    }
    
    public void setDecription(String d){
        this.itemDescription = d;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getOwner(){
        return owner.getUserName();
    }
    
    public void setSalePrice(int n){
        this.salePrice = n;
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

    /*Method for adding an item to a cart. Takes one from the one in inventory and clones itself with quantity one to add to shopping cart
    This avoid having to have a seperate class for individual items.

    This method takes an item from the inventory, adjusts the quantity, and if it 0's out an item, removes it's entry from the inventory.
    */

    public Item getOne() throws RuntimeException{
        Item i = this.clone();
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


    /* Method for putting a single item back into inventory
    */
    public void putOne() throws RuntimeException{
        Item item = this.clone;
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
            Item fix = inv.getItem(i);
            fix.incrementQuantity();
        }

        

    }

    public void incrementQuantity(){
        quantity++;
    }

}



    
    
    


