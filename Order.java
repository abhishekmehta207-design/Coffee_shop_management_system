// =============================================
//  Order.java
//  Concept: CLASS & OBJECT, ArrayList
// =============================================

import java.util.ArrayList;

public class Order {

    private String customerName;
    private ArrayList<MenuItem> items;   // ArrayList to store ordered items

    // Constructor
    public Order(String customerName) {
        this.customerName = customerName;
        this.items        = new ArrayList<>();  // create empty list
    }

    // Add item to order
    public void addItem(MenuItem item) {
        items.add(item);
        System.out.println("  Added: " + item.getName());
    }

    // Remove item from order
    public void removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                items.remove(i);
                System.out.println("  Removed: " + itemName);
                return;
            }
        }
        System.out.println("  Item not found: " + itemName);
    }

    // Calculate total bill
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice();
        }
        return total;
    }

    // Print the bill
    public void printBill() {
        System.out.println("\n====================================");
        System.out.println("       SUNSHINE COFFEE - BILL       ");
        System.out.println("====================================");
        System.out.println("Customer : " + customerName);
        System.out.println("------------------------------------");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("  " + items.get(i).getName()
                               + "  -  Rs. " + items.get(i).getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("  TOTAL   :  Rs. " + calculateTotal());
        System.out.println("====================================\n");
    }

    // Getters
    public String getCustomerName()      { return customerName; }
    public ArrayList<MenuItem> getItems(){ return items; }
}
