package shopsafe;

/**
 * User information class
 *
 * @author Daniel Bennett
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
    public static final int STANDARD_ACCOUNT = 1; //A normal user account
    public static final int SELLER_ACCOUNT = 2; //A seller account
    public static final int ADMIN_ACCOUNT = 3; //An administrator account(unused currently)
    LinkedList<Transaction> purchases;


    /**
     * 
     * @param un Username
     * @param pw Password - These are store unhashed/unsalted
     * @param access ACCOUNT ACCESS LEVEL(see static members)
     */
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

    public boolean equals(User u){
        if(u.getUserName().equals(this.userName)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean equals(String s){
        if(s.equals(userName)){
            return true;
        }
        else{
            return false;
        }
    }
    
    

}
