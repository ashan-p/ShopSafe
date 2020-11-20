
/**
 * Login Subsystem
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.LinkedList;
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
    
    public int signUp(String un,String pw,int acc){
        User u = new User(un,pw,acc);
        if(users.get(un) == null){
            users.put(u.getUserName(),u);
            save();
            return SIGNUP_SUCCESS;
            
        }
        else{
            return USERNAME_EXISTS;
        }
        
        
    }
    
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
    
    public static Login getInstance(){
        return instance;
    }

}
