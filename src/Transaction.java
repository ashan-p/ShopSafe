
/**
 * 
 * @author Daniel Bennett
 * 
*/

import java.util.Date;

public class Transaction
{
    String seller;
    String purchaser;
    Date time;
    String itemName;
    int basePrice;
    int salePrice;
    public Transaction(User s,User p,Item i)
    {
        time = new Date();
        this.purchaser = p.getUserName();
        this.seller = s.getUserName();
        this.itemName = i.getItemName();
        this.basePrice = i.getBasePrice();
        this.salePrice = i.getSalePrice();       
        
    }

}
