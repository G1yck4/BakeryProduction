import java.util.ArrayList;
import java.util.Scanner;

public class BreadInventory {
    private ArrayList<Bread> breadInventory;
    
    public BreadInventory() {
        this.breadInventory = new ArrayList<>();
    }

    public ArrayList<Bread> getBreadList() {
        return breadInventory;
    }

    public void addBread(String Name, int quantity) {
        boolean found = false;
        for (Bread bread : breadInventory) {
            if (bread.getBreadName().equalsIgnoreCase(Name)) {
                bread.setBreadQuantity(bread.getBreadQuantity() + quantity);
                System.out.printf("Added %d %s to the Bread Inventory. New total: %d%n", quantity, Name, bread.getBreadQuantity());
                found = true;
                break;
            }
        } 
     
        if (!found) {
            breadInventory.add(new Bread(Name, quantity));
            System.out.printf("Added new bread: %s (%d units)%n", Name, quantity);
        }
    }
        public void checkBreadInventory() {
            if (breadInventory.isEmpty()) {
                System.out.println("The  bread inventory is empty.");
            } else {
                System.out.println("Current Bread Inventory:");
                for (Bread bread : breadInventory) {
                    System.out.printf(" %s: %d pc/s", bread.getBreadName(), bread.getBreadQuantity());
                }
            
            }
    }
    }
