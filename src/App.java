import javax.swing.JFrame;

/**
 * The entry point to the App. Creates a window and shows the login page.
 */
public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("ShopSafe");
        frame.setSize(600, 480);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);                              // currently resizing disabled
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new LoginPage());

        frame.setVisible(true);
    }
}
