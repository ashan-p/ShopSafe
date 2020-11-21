
/**
 * Write a description of class TEST here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TEST
{
    public static void main(String[] Args){
        Login database = Login.getInstance();
        //database.signUp("Daniel", "abc123", User.STANDARD_ACCOUNT);
        User u = database.login("Daniel","abc123");
        System.out.println(u.getUserName());
    }
    
}
