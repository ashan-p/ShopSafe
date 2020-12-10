package shopsafe;

/**
 * Login Subsystem aggregates users and provides login/signup services
 *
 * @author Daniel Bennett
 * @version 1.0
 */

import java.io.*;
import java.util.HashMap;


public class Login
{
    HashMap<String,User> users;
    public static Login instance = new Login();
    public static final int USERNAME_EXISTS = 10;
    public static final int SIGNUP_SUCCESS = 15;
    public static final int INVALID_USERNAME = 20;
    public static final int INVALID_PASSWORD = 25;
    
    
    public static class UsernameExists extends Exception {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
    }
    
    private Login()
    {
        try{
            FileInputStream fileIn = new FileInputStream("users.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (HashMap<String,User>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (Exception e){
            users = new HashMap<String,User>();
        }
            
        
    }
    
    /**
     * Saves the object to disk
     * @return true if successful, else false
     */
    public boolean save(){
         try {
             FileOutputStream fileOut =
             new FileOutputStream("users.dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(users);
             out.close();
             fileOut.close();
             return true;
         }
         catch(Exception e){
             return false;
         }
    }
    
    /**
     * Creates a new user account
     * @param un Username - Must be Unique
     * @param pw password
     * @param acc access level - see static class members
     * @return User if successful, else exception
     * @throws UsernameExists
     */
    public User signUp(String un,String pw,int acc) throws UsernameExists {
        User u = new User(un,pw,acc);
        if(users.get(un) == null){
            users.put(u.getUserName(),u);
            save();
            return u;//return SIGNUP_SUCCESS;
        }
        else{
            throw new UsernameExists();//return USERNAME_EXISTS;
        }
    }
    

    /**
     * Login
     * @param un Username
     * @param pw Password
     * @return the User if successful, else null;
     */
    public User login(String un,String pw){
        User u = users.get(un);
        
        if(u == null){
            return null;
        }
        if(u.getPassword().equals(pw)){
            return u;
        }
        return null;
        
    }
    /**
     * Get instance for the singleton
     * @return the instance
     */
    public static Login getInstance(){
        return instance;
    }

}
