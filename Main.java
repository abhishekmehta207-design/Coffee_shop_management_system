// =============================================
//  Main.java  —  Entry Point
//
//  CONCEPTS USED:
//  1. OOP  — Classes, Objects, Methods,
//             Constructors, Encapsulation
//  2. ArrayList — store menu items & orders
//  3. Switch-case — menu driven program
// =============================================

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // --- Create shop and add menu items (OOP: creating objects) ---
        CoffeeShop shop = new CoffeeShop("Sunshine Coffee");

        shop.addToMenu(new MenuItem("Espresso",       80,  "Coffee"));
        shop.addToMenu(new MenuItem("Cappuccino",     120,  "Coffee"));
        shop.addToMenu(new MenuItem("Latte",          140,  "Coffee"));
        shop.addToMenu(new MenuItem("Cold Brew",      160,  "Coffee"));
        shop.addToMenu(new MenuItem("Croissant",       90,  "Snack"));
        shop.addToMenu(new MenuItem("Muffin",          80,  "Snack"));
        shop.addToMenu(new MenuItem("Brownie",         70,  "Snack"));
        shop.addToMenu(new MenuItem("Hot Chocolate",  110,  "Drinks"));
        shop.addToMenu(new MenuItem("Green Tea",       60,  "Drinks"));

        // --- Current active order ---
        Order currentOrder = null;

        System.out.println("*************************************");
        System.out.println("  Welcome to Sunshine Coffee Shop!  ");
        System.out.println("*************************************");

        boolean running = true;

        while (running) {

            // Main menu using switch-case
            System.out.println("---------- MAIN MENU ----------");
            System.out.println("  1. View Full Menu");
            System.out.println("  2. View Menu by Category");
            System.out.println("  3. Create New Order");
            System.out.println("  4. Add Item to Order");
            System.out.println("  5. Remove Item from Order");
            System.out.println("  6. View Current Order / Bill");
            System.out.println("  7. Place Order (Checkout)");
            System.out.println("  8. Exit");
            System.out.println("-------------------------------");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear leftover newline

            switch (choice) {

                case 1:
                    // View full menu
                    shop.displayMenu();
                    break;

                case 2:
                    // View by category — another switch-case inside!
                    System.out.println("Select Category:");
                    System.out.println("  1. Coffee");
                    System.out.println("  2. Snack");
                    System.out.println("  3. Drinks");
                    System.out.print("Choice: ");
                    int catChoice = sc.nextInt();
                    sc.nextLine();

                    switch (catChoice) {
                        case 1:
                            shop.displayCategory("Coffee");
                            break;
                        case 2:
                            shop.displayCategory("Snack");
                            break;
                        case 3:
                            shop.displayCategory("Drinks");
                            break;
                        default:
                            System.out.println("Invalid category choice.\n");
                    }
                    break;

                case 3:
                    // Create a new order
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    currentOrder = new Order(name);
                    System.out.println("Order created for " + name + "!\n");
                    break;

                case 4:
                    // Add item to current order
                    if (currentOrder == null) {
                        System.out.println("Please create an order first (Option 3).\n");
                    } else {
                        shop.displayMenu();
                        System.out.print("Enter item name to add: ");
                        String itemName = sc.nextLine();
                        MenuItem found = shop.findItem(itemName);
                        if (found != null) {
                            currentOrder.addItem(found);
                            System.out.println();
                        } else {
                            System.out.println("Item not found on menu.\n");
                        }
                    }
                    break;

                case 5:
                    // Remove item from current order
                    if (currentOrder == null) {
                        System.out.println("No active order.\n");
                    } else {
                        System.out.print("Enter item name to remove: ");
                        String removeName = sc.nextLine();
                        currentOrder.removeItem(removeName);
                        System.out.println();
                    }
                    break;

                case 6:
                    // View current order / bill
                    if (currentOrder == null) {
                        System.out.println("No active order. Please create one first.\n");
                    } else {
                        currentOrder.printBill();
                    }
                    break;

                case 7:
                    // Place order and checkout
                    if (currentOrder == null) {
                        System.out.println("No active order.\n");
                    } else if (currentOrder.getItems().size() == 0) {
                        System.out.println("Cannot checkout — order is empty!\n");
                    } else {
                        currentOrder.printBill();
                        System.out.println("Order placed! Thank you, "
                            + currentOrder.getCustomerName() + "!");
                        System.out.println("Your order will be ready shortly.\n");
                        currentOrder = null;   // reset for next customer
                    }
                    break;

                case 8:
                    // Exit
                    System.out.println("\nThank you for visiting Sunshine Coffee!");
                    System.out.println("Goodbye! :)");
                    running = false;
                    break;

                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Please enter 1-8.\n");
            }
        }

        sc.close();
    }
}
