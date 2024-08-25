import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Management extends User {

    public Management(String Username, String Password) {
        super(Username, Password);
    }


    @Override
    public void main(User user) {
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Welcome to Management. as you can see; the HELP are shown below:");
        System.out.println("addSome: this command allows you to add only some of ingredients.");
        System.out.println("check: this, allows you to check all ingredients.");
        System.out.println("handle: this, allows you to + or - ingredients");
        System.out.println("available: this, shows you the available ingredients.");
        System.out.println("show: this, shows you all submitted orders.");
        System.out.println("cancel: to canceling an order, type it.");


        String w = scan.nextLine();


        if (w.equalsIgnoreCase("addsome")) {
            Storage.addSomeIngredients(scan, user);
            main(user);
        }


        if (w.equalsIgnoreCase("check")) {
            Storage.checkIngredients(scan, user);
            main(user);
        }

        if (w.equalsIgnoreCase("handle")) {
            Storage.HandlingIngredients(scan, user);
            main(user);
        }


        if (w.equalsIgnoreCase("available")) {
            Storage.showAvailableIngredients(scan, user);
            main(user);
        }

        if (w.equalsIgnoreCase("show")) {
            System.out.println(Order.allOrderIDs.toString());
            main(user);
        }

        if (w.equalsIgnoreCase("cancel")) {
            int x = scan.nextInt();
            Order.allOrderIDs.remove(x);

            for (User u : users) {
                u.specificOrderID.remove(x);
            }

            main(user);
        } else if (w.equalsIgnoreCase("back")) {
            CLI.noob();
        } else {
            System.out.println("Command invalid! try again.");
            main(user);
        }

    }


}

