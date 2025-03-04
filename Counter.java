import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Counter {
    private BreadInventory breadInventory;
    private Scanner scanner;

    private final int PANDESAL_PRICE = 5;
    private final int MAMON_PRICE = 18;
    private final int LOAF_PRICE = 30;
    private final int ENSAYMADA_PRICE = 20;
    private final int SPANISH_ROLL_PRICE = 12;

    public Counter(BreadInventory breadInventory, Scanner scanner) {
        this.breadInventory = breadInventory;
        this.scanner = scanner;
    }

    public void startCounter() {
        while (true) {
            System.out.println("\n_Cashier_");
            System.out.println("[1] Browse Goods");
            System.out.println("[2] Buy Goods");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");
            int choice = getValidIntegerInput();

            switch (choice) {
                case 1:
                    browseGoods();
                    break;
                case 2:
                    buyGoods();
                    break;
                case 3:
                    System.out.println("Exiting the counter.");
                    return;
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }
    }

    private void browseGoods() {
        System.out.println("Made Bread Inventory:");
        int index = 1; 
        for (Bread bread : breadInventory.getBreadList()) {
            String breadName = bread.getBreadName();
            int quantity = bread.getBreadQuantity();
            if (quantity > 0) { 
                System.out.printf("[%d] %s: %d pcs, Price: %d pesos%n", index++, breadName, quantity, getPrice(breadName));
            }
        }
    }

    private void buyGoods() {
        int quantity = 0;
        while (true) {
            System.out.print("Enter the quantity you want to buy: ");
            quantity = getValidIntegerInput();
            if (quantity > 0) {
                break;
            } else {
                System.out.println("Invalid quantity. Please enter a positive number.");
            }
        }

        browseGoods();

        int breadChoice = 0;
        String breadName = null; // Declare breadName here
        while (true) {
            System.out.print("Enter the number of the bread: ");
            breadChoice = getValidIntegerInput();
            breadName = getBreadName(breadChoice); // Assign breadName here
            
            if (breadName != null) {
                for (Bread bread : breadInventory.getBreadList()) {
                    if (bread.getBreadName().equalsIgnoreCase(breadName)) {
                        if (quantity > bread.getBreadQuantity()) {
                            System.out.printf("Not enough %s in stock. Available: %d%n", breadName, bread.getBreadQuantity());
                            return;
                        }
                        break; 
                    }
                }
                break; // Valid bread choice, exit the loop
            } else {
                System.out.println("Invalid bread choice. Please try again.");
            }
        }

        System.out.println("[1] Discount");
        System.out.println("[2] Regular");
        System.out.print("Choose an option: ");
        int buyOption = getValidIntegerInput();

        switch (buyOption) {
            case 1:
                processPurchase(breadName, quantity, true);
                break;
            case 2:
                processPurchase(breadName, quantity, false);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void processPurchase(String breadName, int quantity, boolean isDiscount) {
        for (Bread bread : breadInventory.getBreadList()) {
            if (bread.getBreadName().equalsIgnoreCase(breadName)) {
                if (bread.getBreadQuantity() >= quantity) {
                    int price = getPrice(breadName);
                    int total = price * quantity;
                    int discountedTotal = isDiscount ? (int) (total * 0.9) : total; 

                    bread.setBreadQuantity(bread.getBreadQuantity() - quantity);

                    System.out.printf("You have purchased %d %s(s).%n", quantity, breadName);
                    System.out.printf("Price per unit: %d pesos%n", price);
                    System.out.printf("Total: %d pesos%n", total);
                    if (isDiscount) {
                        System.out.printf("Discounted Total (10%% off): %d pesos%n", discountedTotal);
                    }
                    return;
                } else {
                    System.out.printf("Not enough %s in stock. Available: %d%n", breadName, bread.getBreadQuantity());
                    return;
                }
            }
        }
        System.out.printf("Sorry, %s is not available in the inventory.%n", breadName);
    }

    private int getPrice(String breadName) {
        switch (breadName.toLowerCase()) {
            case "pandesal":
                return PANDESAL_PRICE;
            case "mamon":
                return MAMON_PRICE;
            case "loaf":
                return LOAF_PRICE;
            case "ensaymada":
                return ENSAYMADA_PRICE;
            case "spanish roll":
                return SPANISH_ROLL_PRICE;
            default:
                return 0;
        }
    }

    public String getBreadName(int index) {
        switch (index) {
            case 1: return "Pandesal";
            case 2: return "Mamon";
            case 3: return "Loaf";
            case 4: return "Ensaymada";
            case 5: return "Spanish Roll";
            default: return null; 
        }
    }

    private int getValidIntegerInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Choose an option: ");
                scanner.nextLine(); 
            }
        }
    }
}