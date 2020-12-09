package shopsafe;

public class UserTest {
    public static void main(String[] Args){

        User user = new User("Daniel","abc123",User.STANDARD_ACCOUNT);

        System.out.println("Testing getUserName()");
        assert(user.getUserName().equals("Daniel"));

        System.out.println("Testing getPassword()");
        assert(user.getPassword().equals("abc123"));

        System.out.println("Testing equals()");
        User userone = new User("Daniel","123abc",User.ADMIN_ACCOUNT);
        assert(!user.equals(userone));



    }
}
