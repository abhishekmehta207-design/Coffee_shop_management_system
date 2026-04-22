// =============================================
//  CoffeeShop.java
//  Concept: CLASS & OBJECT, ArrayList, Methods
// =============================================

import java.util.ArrayList;

public class CoffeeShop {

    private String shopName;
    private ArrayList<MenuItem> menu;   // ArrayList to store all menu items

    // Constructor
    public CoffeeShop(String shopName) {
        this.shopName = shopName;
        this.menu     = new ArrayList<>();
    }

    // Add item to menu
    public void addToMenu(MenuItem item) {
        menu.add(item);
    }

    // Display full menu
    public void displayMenu() {
        System.out.println("\n====================================");
        System.out.println("    " + shopName.toUpperCase() + " - MENU");
        System.out.println("====================================");
        for (int i = 0; i < menu.size(); i++) {
            System.out.print("  " + (i + 1) + ". ");
            menu.get(i).displayItem();
        }
        System.out.println("====================================\n");
    }

    // Find item by name and return it
    public MenuItem findItem(String name) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getName().equalsIgnoreCase(name)) {
                return menu.get(i);
            }
        }
        return null;
    }

    // Display items of one category only
    public void displayCategory(String category) {
        System.out.println("\n--- " + category + " Items ---");
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getCategory().equalsIgnoreCase(category)) {
                menu.get(i).displayItem();
            }
        }
        System.out.println();
    }

    // Getters
    public String getShopName()          { return shopName; }
    public ArrayList<MenuItem> getMenu() { return menu; }
}
