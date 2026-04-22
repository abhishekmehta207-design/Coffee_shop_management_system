// =============================================
//  MenuItem.java
//  Concept: CLASS & OBJECT, Encapsulation
// =============================================

public class MenuItem {

    // Private fields (Encapsulation)
    private String name;
    private double price;
    private String category;

    // Constructor
    public MenuItem(String name, double price, String category) {
        this.name     = name;
        this.price    = price;
        this.category = category;
    }

    // Getters
    public String getName()     { return name; }
    public double getPrice()    { return price; }
    public String getCategory() { return category; }

    // Setter
    public void setPrice(double price) {
        this.price = price;
    }

    // Method to display item info
    public void displayItem() {
        System.out.println("  " + name + " (" + category + ") - Rs. " + price);
    }
}
