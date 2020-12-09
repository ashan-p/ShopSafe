package shopsafe;

/**
 * Class for keeping track of completed transactions
 * Used for calculating how much money sellers have made
 * @author Daniel Bennett
 * 
*/

import java.util.Date;

public class Transaction implements java.io.Serializable
{
    String seller;
    String purchaser;
    Date time;
    String itemName;
    int basePrice;
    int salePrice;

    /**
     * 
     * @param s Seller
     * @param p Purchaser
     * @param i Item being purchased
     */
    public Transaction(User s,User p,Item i)
    {
        time = new Date();
        this.purchaser = p.getUserName();
        this.seller = s.getUserName();
        this.itemName = i.getItemName();
        this.basePrice = i.getBasePrice();
        this.salePrice = i.getSalePrice();       
        
    }

    public String getSeller(){
        return this.seller;
    }

    public String getPurchaser(){
        return this.purchaser;
    }

    public String getItemName(){
        return this.itemName;
    }

    public int getBasePrice(){
        return basePrice;
    }

    public int getSalePrice(){
        return salePrice;
    }

    public Date getDate(){
        return this.time;
    }



    public int getProfit(){
        return this.salePrice - this.basePrice;
    }


}
