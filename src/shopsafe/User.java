package shopsafe;

/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.LinkedList;
import java.util.Date;
public class User implements java.io.Serializable
{
    private Date created;
    private int accessLevel;
    private String userName;
    private String password;
    public static final int STANDARD_ACCOUNT = 1;
    public static final int SELLER_ACCOUNT = 2;
    public static final int ADMIN_ACCOUNT = 3;
    LinkedList<Transaction> purchases;

    public User(String un,String pw,int access)
    {
        created = new Date();
        this.userName = un;
        this.password = pw;
        this.accessLevel = access;
        purchases = new LinkedList<Transaction>();
        
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String s){
        this.password = s;
    }
    
    public void addTransaction(Transaction t){
        purchases.add(t);
    }
    
    

}
