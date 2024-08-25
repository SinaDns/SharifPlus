import java.sql.SQLOutput;
import java.util.Scanner;

abstract class Product {

    String name;
    String[] INGREDIENTS = new String[]{"flour", "cheese", "meat", "bread", "potato", "coffee",
            "tea", "chocolate", "icecream", "water", "egg", "chicken", "apple", "vegetable"};


    static void showIngredients(Scanner scan) {

        System.out.println("for showing the ingredients of each product, type the desired product.");
        String inp = scan.nextLine();

        if (inp.equalsIgnoreCase("burger")) {
            System.out.println("meat, bread");
        }
        if (inp.equalsIgnoreCase("coffee")) {
            System.out.println("there is nothing special :)");
        }
        if (inp.equalsIgnoreCase("pizza")) {
            System.out.println("meat, chicken, bread, cheese");
        }
        if (inp.equalsIgnoreCase("kebab")) {
            System.out.println("water, meat");
        }
        if (inp.equalsIgnoreCase("water")) {
            System.out.println("there is nothing special :)");
        }
        if (inp.equalsIgnoreCase("cocacola")) {
            System.out.println("Water, Sugar");
        }
        if (inp.equalsIgnoreCase("sharbat")) {
            System.out.println("Water, Sugar");
        }
        if (inp.equalsIgnoreCase("tiramisu")) {
            System.out.println("egg, flour, chocolate");
        }
        if (inp.equalsIgnoreCase("milkchocolate")) {
            System.out.println("sugar, chocolate");
        }
        if (inp.equalsIgnoreCase("icecream")) {
            System.out.println("sugar, chocolate");
        }
        if (inp.equalsIgnoreCase("frenchfries")) {
            System.out.println("potato");
        }
        if (inp.equalsIgnoreCase("salad")) {
            System.out.println("vegetable");
        }
        if (inp.equalsIgnoreCase("cheesecake")) {
            System.out.println("chocolate, flour, coffee");
        }
        if (inp.equalsIgnoreCase("applepie")) {
            System.out.println("apple");
        }

    }

}


class Food extends Product {



    class Burger extends Food {
        String name = "Burger";
        String[] ingredients = new String[]{};
    }

    class Kebab extends Food {
        String name = "Kebab";
        String[] ingredients = new String[]{"water", "meat"};
    }

    class Pizza extends Food {
        String name = "Pizza";
        String[] ingredients = new String[]{"meat, chicken, bread, cheese"};
    }

}

class Drink extends Product {

    class Water extends Drink {
        String name = "water";
        String[] ingredients = new String[]{"Water!!"};
    }

    class CocaCola extends Drink {
        String name = "cocacola";
        String[] ingredients = new String[]{"Water", "sugar"};
    }

    class Sharbat extends Drink {
        String name = "sharbat";
        String[] ingredients = new String[]{"water", "sugar"};
    }

}

class Dessert extends Product {

    class Tiramisu extends Dessert {
        String name = "tiramisu";
        String[] ingredients = new String[]{"egg", "flour", "chocolate"};
    }

    class IceCream extends Dessert {
        String name = "icecream";
        String[] ingredients = new String[]{"sugar", "chocolate"};
    }

}

class Starter extends Product {

    class FrenchFries extends Starter {
        String name = "FrenchFries";
        String[] ingredients = new String[]{"potato"};
    }

    class Salad extends Starter {
        String name = "Salad";
        String[] ingredients = new String[]{"vegetable"};
    }

}


class Cake extends Product {

    class CheeseCake extends Cake {
        String name = "cheesecake";
        String[] ingredients = new String[]{"chocolate", "flour", "coffee"};
    }

    class ApplePie extends Cake {
        String name = "applepie";
        String[] ingredients = new String[]{"apple"};
    }

}