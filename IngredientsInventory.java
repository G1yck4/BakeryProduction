import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class IngredientsInventory {
    private ArrayList<Ingredient> ingredients;
    private Scanner scanner;
    private BreadInventory breadInventory;

    public IngredientsInventory(Scanner scanner, BreadInventory breadInventory){ 
        this.ingredients = new ArrayList<>();
        this.scanner = scanner;
        this.breadInventory = breadInventory;
    }
   
    public void addOrRestock() {
        while(true){
        try{
            System.out.print("Enter amount of ingredients to be added: ");
            int count = scanner.nextInt();
            scanner.nextLine();
            
            if (count <= 0) {
                System.out.println("Please enter a positive number.");
                continue;
            }

            for (int i = 0; i < count; i++){
                System.out.println("\nIngredient #" + (i + 1));
                System.out.print("Enter ingredient name: ");
                String name = scanner.nextLine().trim(); 

                int quantity = 0;
                while (true){
                    try{
                    System.out.print("Enter quantity to add/restock: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); 

                    if (quantity > 0) {
                        break;
                    }else{
                        System.out.println("Please enter a positive number.");
                    }
                }catch(InputMismatchException e){
                    System.out.println("Enter valid amount of Number: ");
                    scanner.nextLine();
                    }
                }
                boolean found = false;
                for (Ingredient ingredient : ingredients) {
                    if (ingredient.getName().equalsIgnoreCase(name)) {
                        ingredient.setQuantity(ingredient.getQuantity() + quantity);
                        System.out.printf("Restocked %s. New total: %d units%n", name, ingredient.getQuantity());
                        found = true;
                        break;
                    }
                }

            if (!found){
                ingredients.add(new Ingredient(name, quantity));
                System.out.printf("Added new ingredient: %s (%d units)%n", name, quantity);
                }
            } 
            break;
        }catch(InputMismatchException e){
            System.out.println("Enter valid amount of Number: ");
            scanner.nextLine();
        } 
    }
}
    public void recallAmountOfIngredient(String ingredientName, int amountOfIngredient, String ingredientName2, int amountOfIngredient2,String ingredientName3, int amountOfIngredient3,String breadName) {
        Ingredient ingredient1 = null;
        Ingredient ingredient2 = null;
        Ingredient ingredient3 = null;
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(ingredientName)) {
                if (ingredient.getQuantity() >= amountOfIngredient) {
                    ingredient1=ingredient;
                    break;
                } else {
                    System.out.printf("Not enough %s!", ingredientName, ingredient.getQuantity());
                    return;
                }
            }
        }
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(ingredientName2)) {
                if (ingredient.getQuantity() >= amountOfIngredient2) {
                    ingredient2=ingredient;
                    break;
                } else {
                    System.out.printf("Not enough %s!", ingredientName2, ingredient.getQuantity());
                    return;
                }
            }
        }
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(ingredientName3)) {
                if (ingredient.getQuantity() >= amountOfIngredient3) {
                    ingredient3=ingredient;
                    break;
                } else {
                    System.out.printf("Not enough %s!", ingredientName3, ingredient.getQuantity());
                    return;
                }
            }
        }
        if (ingredient1 !=null && ingredient2 !=null && ingredient3 !=null) {
            ingredient1.setQuantity(ingredient1.getQuantity() - amountOfIngredient);
            ingredient2.setQuantity(ingredient2.getQuantity() - amountOfIngredient2);
            ingredient3.setQuantity(ingredient2.getQuantity() - amountOfIngredient3);
            processMaking(breadName);
        } else {
            System.out.println("Not enough ingredients to make "+breadName);
        }
    }

    public void processMaking(String breadName){
        System.out.println("*****Making*****");
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("\n*****Mixing*****");
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("\n*****Baking*****");
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("\n*****Cooling*****");
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println("\nBread is Ready!"+breadName+" added to inventory!");
            breadInventory.addBread(breadName, 1);
            System.out.println(breadName+" has been added to the bread inventory.");
                return;

    }
    public void checkInventory() {
        if (ingredients.isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Ingredient ingredient : ingredients) {
                System.out.printf("- %s: %d units%n", ingredient.getName(), ingredient.getQuantity());
            }
        }
    }
}