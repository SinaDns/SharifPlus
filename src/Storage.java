import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Storage {
    public static HashMap<String, Integer> allIngredients = new HashMap<>();
    public static String[] INGREDIENTS = new String[]{"flour", "cheese", "meat", "bread", "potato", "coffee",
            "tea", "chocolate", "water", "egg", "chicken", "apple", "vegetable", "sugar"};


    static void setIngredients() {
        for (String s : INGREDIENTS) {
            Random random = new Random();
            int x = random.nextInt(11);
            allIngredients.put(s, x);
        }
    }


    static void showAvailableIngredients(Scanner scan, User user) {
        System.out.println("az har ingredient, inghadr mojoodi darim:");
        System.out.println(allIngredients.toString());
        System.out.println();
    }


    // add or remove ingredients
    static void HandlingIngredients(Scanner scan, User user)  {
        System.out.println("Baraye Kam Kardan, Adadetoon ro manfi vared konin, Baraye add kardan, be soorate mamooli.");
        String x1 = scan.nextLine();
        int x = Integer.parseInt(x1);


        for (String s : allIngredients.keySet()) {
            if (allIngredients.get(s) + x < 0) {
                allIngredients.put(s, 0);
            } else {
                allIngredients.put(s, allIngredients.get(s) + x);
            }
        }
        System.out.println("Done!");
        if (x1.equalsIgnoreCase("back")) {
            user.main(user);
        }
    }


    static void addSomeIngredients(Scanner scan, User user)  {
        System.out.println("Baraye ezafe kardan, ebteda esme ingredient, sepas ENTER, sepas meghdare an ra vared konid.");
        System.out.println("Baraye back, ebteda type konid BACK, sepas 0 ra bezanid. ");
        String s2 = scan.nextLine();
        int x = scan.nextInt();

        for (String s : INGREDIENTS) {
            if (s2.equalsIgnoreCase(s))
                allIngredients.put(s2, allIngredients.get(s2) + x);
        }

        if (s2.equalsIgnoreCase("back")) {
            user.main(user);
        }

    }


    static void checkIngredients(Scanner scan, User user)  {

        System.out.println("for check the amount of each ingredient, type it ");
        String s = scan.nextLine();

        System.out.println(allIngredients.get(s));
        System.out.println();

        if (s.equalsIgnoreCase("back")) {
            user.main(user);
        }
    }

}