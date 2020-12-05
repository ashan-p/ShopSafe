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
        int salePrice = n;
    }
    
    public void setBasePrice(int n){
        int basePrice = n;
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



    
    
    

}
