import java.util.Scanner;

public class Customer extends User {

    public Customer(String Username, String Password) {
        super(Username, Password);
    }


    @Override
    public void main(User user) {
        Scanner scan = new Scanner(System.in);

        Store cafe = new Cafe();
        Store restaurant = new Restaurant();

        System.out.println("Select between CAFE or RESTAURANT");
        System.out.println("if you wanna see your Products, type SHOW");
        String s = scan.nextLine();


        // back to createUser
        if (s.equalsIgnoreCase("back"))
            CLI.noob();


        if (s.equalsIgnoreCase("cafe")) {
            cafe.getMenu();
            boolean e1 = true;

            while (e1) {
                e1 = cafe.addOrder(scan, user);
            }

            main(user);
        }

        if (s.equalsIgnoreCase("restaurant")) {
            restaurant.getMenu();
            boolean e1 = true;

            while (e1) {
                e1 = restaurant.addOrder(scan, user);
            }

            main(user);
        }

        if (s.equalsIgnoreCase("show")) {
            System.out.println("Here's your orders:");
            System.out.println(user.specificOrderID.toString());

            main(user);
        }


    }

}

