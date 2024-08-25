import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

abstract class Store {
    public abstract void getMenu();

    public abstract boolean addOrder(Scanner scan, User user);

}


class restaurant extends Store {

    @Override
    public void getMenu() {
        System.out.println("$$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$");
        System.out.println("You're now on restaurant, the menu is:");
        System.out.println("1) Food:");
        System.out.println("       1. Kebab");
        System.out.println("       2. Pizza");
        System.out.println("       3. Burger");

        System.out.println("2) Starter:");
        System.out.println("       1. French Fries");
        System.out.println("       2. Salad");

        System.out.println("3) Drink:");
        System.out.println("       1. Water");
        System.out.println("       2. CocaCola");
        System.out.println("$$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$");
    }


    @Override
    public boolean addOrder(Scanner scan, User user) {

        try {
            FileWriter writer = new FileWriter("outputRES.txt", true);
            Date date = new Date();
            System.out.println("for adding your orders, type them (if they've 2 parts, type without SPACE)");
            System.out.println("if you're interested to see ingredients of products, type SHOW");

            String choice = scan.nextLine();

            if (choice.equalsIgnoreCase("show"))
                Product.showIngredients(scan);

            Order order = new Order(user);

            if (choice.toLowerCase().contains("pizza")) {

                if (Storage.allIngredients.get("meat") > 0 && Storage.allIngredients.get("bread") > 0
                        && Storage.allIngredients.get("chicken") > 0 && Storage.allIngredients.get("cheese") > 0) {
                    Product pizza = new Food();
                    order.productList.add(pizza);
                    Storage.allIngredients.put("meat", Storage.allIngredients.get("meat") - 1);
                    Storage.allIngredients.put("chicken", Storage.allIngredients.get("chicken") - 1);
                    Storage.allIngredients.put("bread", Storage.allIngredients.get("bread") - 1);
                    Storage.allIngredients.put("cheese", Storage.allIngredients.get("cheese") - 1);
                    System.out.println("pizza added successfully");
                    user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " pizza");
                    Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " pizza");
                    writer.write(user.Username + "has ordered a Pizza, at: " + date);
                } else if (Storage.allIngredients.get("meat") == 0 || Storage.allIngredients.get("bread") == 0
                        || Storage.allIngredients.get("chicken") == 0 || Storage.allIngredients.get("cheese") == 0) {
                    System.out.println("not enough ingredients in storage. sorry!");
                }

            }
            if (choice.toLowerCase().contains("burger")) {

                if (Storage.allIngredients.get("meat") > 0 && Storage.allIngredients.get("bread") > 0) {
                    Product burger = new Food();
                    order.productList.add(burger);
                    Storage.allIngredients.put("meat", Storage.allIngredients.get("meat") - 1);
                    Storage.allIngredients.put("bread", Storage.allIngredients.get("bread") - 1);
                    System.out.println("burger added successfully");
                    user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " burger");
                    Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " burger");
                    writer.write(user.Username + "has ordered a burger, at: " + date);
                } else if (Storage.allIngredients.get("meat") == 0 || Storage.allIngredients.get("bread") == 0) {
                    System.out.println("not enough ingredients in storage. sorry!");
                }

            }
            if (choice.toLowerCase().contains("kebab")) {

                if (Storage.allIngredients.get("meat") > 0 && Storage.allIngredients.get("water") > 0) {
                    Product kebab = new Food();
                    order.productList.add(kebab);
                    Storage.allIngredients.put("meat", Storage.allIngredients.get("meat") - 1);
                    Storage.allIngredients.put("water", Storage.allIngredients.get("water") - 1);
                    System.out.println("kebab added successfully");
                    user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " kebab");
                    Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " kebab");
                    writer.write(user.Username + "has ordered a kebab, at: " + date);
                } else if (Storage.allIngredients.get("meat") == 0 || Storage.allIngredients.get("water") == 0) {
                    System.out.println("not enough ingredients in storage. sorry!");
                }

            }
            if (choice.toLowerCase().contains("frenchfries")) {

                if (Storage.allIngredients.get("potato") > 0) {
                    Product frenchFries = new Starter();
                    order.productList.add(frenchFries);
                    Storage.allIngredients.put("potato", Storage.allIngredients.get("potato") - 1);
                    System.out.println("french fries added successfully");
                    user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " frenchfries");
                    Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " frenchfries");
                    writer.write(user.Username + "has ordered a FrenchFries, at: " + date);
                } else if (Storage.allIngredients.get("potato") == 0) {
                    System.out.println("not enough ingredients in storage. sorry!");
                }

            }
            if (choice.toLowerCase().contains("salad")) {

                if (Storage.allIngredients.get("vegetable") > 0) {
                    Product salad = new Starter();
                    order.productList.add(salad);
                    Storage.allIngredients.put("vegetable", Storage.allIngredients.get("vegetable") - 1);
                    System.out.println("salad added successfully");
                    user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " salad");
                    Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " salad");
                    writer.write(user.Username + "has ordered a Salad, at: " + date);
                } else if (Storage.allIngredients.get("vegetable") == 0) {
                    System.out.println("not enough ingredients in storage. sorry!");
                }

            }
            if (choice.toLowerCase().contains("water")) {

                if (Storage.allIngredients.get("water") > 0) {
                    Product water = new Drink();
                    order.productList.add(water);
                    Storage.allIngredients.put("water", Storage.allIngredients.get("water") - 1);
                    System.out.println("water added successfully");
                    user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " water");
                    Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " water");
                    writer.write(user.Username + "has ordered a water, at: " + date);
                } else if (Storage.allIngredients.get("water") == 0) {
                    System.out.println("not enough ingredients in storage. sorry!");
                }

            }
            if (choice.toLowerCase().contains("cocacola")) {

                if (Storage.allIngredients.get("water") > 0 && Storage.allIngredients.get("sugar") > 0) {
                    Product cocacola = new Drink();
                    order.productList.add(cocacola);
                    Storage.allIngredients.put("water", Storage.allIngredients.get("water") - 1);
                    Storage.allIngredients.put("sugar", Storage.allIngredients.get("sugar") - 1);
                    System.out.println("water added successfully");
                    user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " cocacola");
                    Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " cocacola");
                    writer.write(user.Username + "has ordered a CocaCola, at: " + date);
                } else if (Storage.allIngredients.get("water") == 0 || Storage.allIngredients.get("sugar") == 0) {
                    System.out.println("not enough ingredients in storage. sorry!");
                }

            }
            if (choice.equalsIgnoreCase("back")) {
                writer.close();
                return false;
            }
            if (!choice.toLowerCase().contains("pizza") && !choice.toLowerCase().contains("burger") && !choice.toLowerCase().contains("kebab")
                    && !choice.toLowerCase().contains("frenchfries") && !choice.toLowerCase().contains("salad") && !choice.toLowerCase().contains("water")
                    && !choice.toLowerCase().contains("cocacola") && !choice.equalsIgnoreCase("back")) {
                System.out.println("Not in menu.");
                System.out.println();
            }

            writer.close();
            Order.id++;
            return true;

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }
}


    class cafe extends Store {


        public void getMenu() {
            System.out.println("$$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$");
            System.out.println("1) Drinks:");
            System.out.println("     i: HOT");
            System.out.println("             a. Tea");
            System.out.println("             b. Coffee");
            System.out.println("             c. Milk Chocolate");
            System.out.println("     ii: COLD");
            System.out.println("             a. Water");
            System.out.println("             b. CocaCola");
            System.out.println("             c. Sharbat");
            System.out.println("2) Dessert:");
            System.out.println("         1. Tiramisu");
            System.out.println("         2. IceCream");
            System.out.println("3) Cakes:");
            System.out.println("         1. Cheese Cake");
            System.out.println("         2. Apple Pie");
            System.out.println("$$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$ $$$");
        }

        @Override
        public boolean addOrder(Scanner scan, User user) {

            try {
                FileWriter writer = new FileWriter("output4.txt", true);
                Date date = new Date();
                System.out.println();
                System.out.println("For adding your orders, type them (if they've 2 parts, type without SPACE)");
                String choice = scan.nextLine();
                Order order = new Order(user);

                if (choice.toLowerCase().contains("tea")) {
                    Product tea = new Drink();
                    order.productList.add(tea);
                    System.out.println("tea added successfully");
                    user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " tea");
                    Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " tea");
                    writer.write(user.Username + "has ordered a tea, at: " + date);
                }
                if (choice.toLowerCase().contains("coffee")) {
                    Product coffee = new Drink();
                    order.productList.add(coffee);
                    System.out.println("coffee added successfully");
                    user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " coffee");
                    Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " coffee");
                    writer.write(user.Username + "has ordered a coffee, at: " + date);
                }
                if (choice.toLowerCase().contains("milkchocolate")) {
                    Product milkchocolate = new Drink();
                    order.productList.add(milkchocolate);
                    Storage.allIngredients.put("sugar", Storage.allIngredients.get("sugar") - 1);
                    Storage.allIngredients.put("chocolate", Storage.allIngredients.get("chocolate") - 1);
                    System.out.println("MilkChocolate added successfully");
                    user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " milkchocolate");
                    Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " milkchocolate");
                    writer.write(user.Username + "has ordered a milkchocolate, at: " + date);
                }
                if (choice.toLowerCase().contains("water")) {

                    if (Storage.allIngredients.get("water") > 0) {
                        Product water = new Drink();
                        order.productList.add(water);
                        System.out.println("Water added successfully");
                        Storage.allIngredients.put("water", Storage.allIngredients.get("water") - 1);
                        user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " water");
                        Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " water");
                        writer.write(user.Username + "has ordered a water, at: " + date);
                    } else if (Storage.allIngredients.get("water") == 0) {
                        System.out.println("not enough ingredients in storage. sorry!");
                    }

                }
                if (choice.toLowerCase().contains("cocacola")) {

                    if (Storage.allIngredients.get("water") > 0 && Storage.allIngredients.get("sugar") > 0) {
                        Product cocacola = new Drink();
                        order.productList.add(cocacola);
                        Storage.allIngredients.put("water", Storage.allIngredients.get("water") - 1);
                        Storage.allIngredients.put("sugar", Storage.allIngredients.get("sugar") - 1);
                        System.out.println("CocaCola added successfully");
                        user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " cocacola");
                        Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " cocacola");
                        writer.write(user.Username + "has ordered a cocacola, at: " + date);
                    } else if (Storage.allIngredients.get("water") == 0 || Storage.allIngredients.get("sugar") == 0) {
                        System.out.println("not enough ingredients in storage. sorry!");
                    }

                }
                if (choice.toLowerCase().contains("sharbat")) {

                    if (Storage.allIngredients.get("water") > 0 && Storage.allIngredients.get("sugar") > 0) {
                        Product sharbat = new Drink();
                        order.productList.add(sharbat);
                        Storage.allIngredients.put("water", Storage.allIngredients.get("water") - 1);
                        Storage.allIngredients.put("sugar", Storage.allIngredients.get("sugar") - 1);
                        System.out.println("Sharbat added successfully");
                        user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " sharbat");
                        Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " sharbat");
                        writer.write("\n" + user.Username + "has ordered a SHARBAT :), at: " + date);
                    } else if (Storage.allIngredients.get("water") == 0 || Storage.allIngredients.get("sugar") == 0) {
                        System.out.println("not enough ingredients in storage. sorry!");
                    }

                }
                if (choice.toLowerCase().contains("tiramisu")) {

                    if (Storage.allIngredients.get("egg") > 0 && Storage.allIngredients.get("flour") > 0
                            && Storage.allIngredients.get("chocolate") > 0) {
                        Product tiramisu = new Dessert();
                        order.productList.add(tiramisu);
                        Storage.allIngredients.put("egg", Storage.allIngredients.get("egg") - 1);
                        Storage.allIngredients.put("flour", Storage.allIngredients.get("flour") - 1);
                        Storage.allIngredients.put("chocolate", Storage.allIngredients.get("chocolate") - 1);
                        System.out.println("Tiramisu added successfully");
                        user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " tiramisu");
                        Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " tiramisu");
                        writer.write(user.Username + "has ordered a tiramisu, at: " + date);
                    } else if (Storage.allIngredients.get("egg") == 0 || Storage.allIngredients.get("flour") == 0
                            || Storage.allIngredients.get("chocolate") == 0) {
                        System.out.println("not enough ingredients in storage. sorry!");
                    }

                }
                if (choice.toLowerCase().contains("icecream")) {

                    if (Storage.allIngredients.get("chocolate") > 0 && Storage.allIngredients.get("sugar") > 0) {
                        Product icecream = new Dessert();
                        order.productList.add(icecream);
                        Storage.allIngredients.put("chocolate", Storage.allIngredients.get("chocolate") - 1);
                        Storage.allIngredients.put("sugar", Storage.allIngredients.get("sugar") - 1);
                        System.out.println("icecream added successfully");
                        user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " icecream");
                        Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " icecream");
                        writer.write(user.Username + "has ordered a icecream, at: " + date);
                    } else if (Storage.allIngredients.get("chocolate") == 0 || Storage.allIngredients.get("sugar") == 0) {
                        System.out.println("not enough ingredients in storage. sorry!");
                    }

                }
                if (choice.toLowerCase().contains("cheesecake")) {

                    if (Storage.allIngredients.get("chocolate") > 0 && Storage.allIngredients.get("flour") > 0
                            && Storage.allIngredients.get("coffee") > 0) {
                        Product CheeseCake = new Cake();
                        order.productList.add(CheeseCake);
                        Storage.allIngredients.put("chocolate", Storage.allIngredients.get("chocolate") - 1);
                        Storage.allIngredients.put("flour", Storage.allIngredients.get("flour") - 1);
                        Storage.allIngredients.put("coffee", Storage.allIngredients.get("coffee") - 1);
                        System.out.println("CheeseCake added successfully");
                        user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " cheesecake");
                        Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " cheesecake");
                        writer.write(user.Username + "has ordered a cheesecake, at: " + date);
                    } else if (Storage.allIngredients.get("chocolate") == 0 || Storage.allIngredients.get("flour") == 0
                            || Storage.allIngredients.get("coffee") == 0) {
                        System.out.println("not enough ingredients in storage. sorry!");
                    }

                }
                if (choice.toLowerCase().contains("applepie")) {

                    if (Storage.allIngredients.get("apple") > 0) {
                        Product applepie = new Cake();
                        order.productList.add(applepie);
                        Storage.allIngredients.put("apple", Storage.allIngredients.get("apple") - 1);
                        System.out.println("Apple Pie added successfully");
                        user.specificOrderID.put(order.getId(), user.specificOrderID.getOrDefault(order.getId(), " ") + " applepie");
                        Order.allOrderIDs.put(order.getId(), Order.allOrderIDs.getOrDefault(order.getId(), " ") + " applepie");
                        writer.write(user.Username + "has ordered a applepie, at: " + date);
                    } else if (Storage.allIngredients.get("apple") == 0) {
                        System.out.println("not enough ingredients in storage. sorry!");
                    }

                }
                if (choice.equalsIgnoreCase("back")) {
                    writer.flush();
                    writer.close();
                    return false;
                }
                if (!choice.toLowerCase().contains("tea") && !choice.toLowerCase().contains("coffee") && !choice.toLowerCase().contains("water")
                        && !choice.toLowerCase().contains("cocacola") && !choice.toLowerCase().contains("sharbat") && !choice.toLowerCase().contains("tiramisu")
                        && !choice.toLowerCase().contains("icecream") && !choice.toLowerCase().contains("cheesecake") && !choice.toLowerCase().contains("applepie")
                        && !choice.toLowerCase().contains("milkchocolate") && !choice.equalsIgnoreCase("back")) {
                    System.out.println("Not in menu.");
                    System.out.println();
                }

                Order.id++;
                writer.flush();
                writer.close();

                return true;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }