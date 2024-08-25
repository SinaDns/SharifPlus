import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class User {

    static List<User> users = new LinkedList<>();
    public String Username;
    String Password;
    HashMap<Integer, String> specificOrderID = new HashMap<>();


    public User(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
        addName(this);
    }

    static void addName(User user) {
        for (User esm : users) {
            if (esm.Username.equals(user.Username)) {
                return;
            }
        }
        users.add(user);
    }

    static User getUserByUsername(String Username) {
        for (User u : users) {
            if (u.Username.equals(Username)) {
                return u;
            }
        }
        return null;
    }

    static boolean checkUsername(String username) {
        for (User esm : users) {
            if (esm.Username.equals(username)) {
                return false;
            }
        }
        return true;
    }

    static void Login(Scanner scan) {
        User user = getUser(scan);
        if (user == null) {
            return;
        }
        getAndCheckPassword(scan, user);
        user.main(user);
    }

    static void getAndCheckPassword(Scanner scan, User user) {
        boolean success = false;
        while (!success) {
            System.out.println("Password ra Vared Konid: ");
            String password = scan.next();

            if (user.Password.equals(password)) {
                System.out.println("Ba Movafaghiyat Login shodid!");
                success = true;
            } else System.out.println("Password Eshtebah Ast. Dobare talash konid");
        }
    }

    static void createUser(Scanner scan) {
        String username = getValidUsername(scan);
        System.out.println("Password ra Vared Konid: ");
        String password = scan.next();
        System.out.println("(Just Type Number)");
        System.out.println("1: Management");
        System.out.println("2: Customer");
        int sel = scan.nextInt();

        if (sel == 1) {
            new Management(username, password);
        }
        if (sel == 2) {
            new Customer(username, password);
        }

        System.out.println("Account Ba Movafaghiyat Sakhte Shod");
    }

    static String getValidUsername(Scanner scan) {
        String username = null;
        while (username == null) {
            System.out.println("Username ra Vared Konid: ");
            username = scan.next();
            if (!User.checkUsername(username)) {
                System.out.println("Username Tekrari Bood. Talashe Mojadad Lotfan");
            }
        }
        return username;
    }

    static User getUser(Scanner scan) {
        User user = null;
        while (user == null) {
            System.out.println("Username ra Vared Konid: ");
            String username = scan.next();
            if ("0".equals(username)) {
                CLI.noob();
            }
            user = User.getUserByUsername(username);
            if (user == null) {
                System.out.println("Username Yaft Nashod! Lotfan Dobare Talash Konid. 0 Ra Baraye Back Vared Konid");
            }
        }
        return user;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public abstract void main(User user);


}


