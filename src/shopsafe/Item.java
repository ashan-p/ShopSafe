package shopsafe;

/**
 * Item class holds information about an item. 
 *
 * @author Daniel Bennett
 * @version (a version number or a date)
 */
public class Item implements Cloneable
{
    String itemName;
    String itemDescription;
    int basePrice; //Price in cents
    int salePrice;
    

    public Item(String in)
    {
        this.itemName = in;
    }
    
    public void setDecription(String d){
        this.itemDescription = d;
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
