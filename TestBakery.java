import java.util.Scanner;

public class TestBakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BreadInventory breadInventory = new BreadInventory();
        IngredientsInventory ingredientsInventory = new IngredientsInventory(scanner, breadInventory);

        while (true) {
            System.out.println("\n__Bakery Production__");
            System.out.println("[1] Ingredients Inventory");
            System.out.println("[2] Make Bread");
            System.out.println("[3] Counter");
            System.out.println("[4] Close Shop");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextLine()) {
                System.out.println("Invalid! Please Enter a number between 1 and 4");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid Choice!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("[1] Check Inventory");
                    System.out.println("[2] Add Stock");
                    System.out.println("[3] Exit");
                    System.out.print("Choose an option: ");
                    int choice2 = scanner.nextInt();

                    if (choice2 == 1) {
                        ingredientsInventory.checkInventory();
                        continue;
                    } else if (choice2 == 2) {
                        ingredientsInventory.addOrRestock();
                        break;
                    } else {
                        continue;
                    }

                case 2:
                    while (true) {
                        System.out.println("\n_Breads_");
                        System.out.println("[1] Pandesal");
                        System.out.println("[2] Mamon");
                        System.out.println("[3] Loaf");
                        System.out.println("[4] Ensaymada");
                        System.out.println("[5] Spanish Roll");
                        System.out.println("[6] CHECK RECIPE");
                        System.out.println("[7] EXIT");
                        System.out.print("Choose bread: ");
                        int choice3 = scanner.nextInt();

                        if (choice3 == 1 || choice3 == 2 || choice3 == 3 || choice3 == 4 || choice3 == 5 || choice3 == 6) {
                            if (choice3 == 1) {
                                ingredientsInventory.recallAmountOfIngredient("Flour", 5, "Egg", 2, "Milk", 1, "Pandesal");
                            } else if (choice3 == 2) {
                                ingredientsInventory.recallAmountOfIngredient("flour", 3, "Egg", 2, "Milk", 3, "Mamon");
                            } else if (choice3 == 3) {
                                ingredientsInventory.recallAmountOfIngredient("flour", 5, "yeast", 2, "Milk", 3, "Loaf");
                            } else if (choice3 == 4) {
                                ingredientsInventory.recallAmountOfIngredient("flour", 4, "sugar", 5, "egg", 2, "Ensaymada");
                            } else if (choice3 == 5) {
                                ingredientsInventory.recallAmountOfIngredient("flour", 4, "Milk", 5, "sugar", 5, "Spanish Roll");
                            } else if (choice3 == 6) {
                                while(true){
                                    System.out.println("");
                                    System.out.println("Pandesal: Flour = 5 | Egg = 2 | Milk = 1");
                                    System.out.println("Mamon: Flour = 3 | Egg = 2 | Milk = 3");
                                    System.out.println("Loaf: Flour = 5 | Yeast = 2 | Milk = 3");
                                    System.out.println("Ensaymada: Flour = 4 | Sugar = 5 | Egg = 2");
                                    System.out.println("Spanish Roll: Flour = 4 | Milk = 5 | Sugar = 5");
                                    System.out.print("Back to Bread Menu [1]: ");
                                    int choiceMenuBack = scanner.nextInt();
                                    if (choiceMenuBack == 1) {
                                        break;
                                    }else{
                                        System.out.println("Please Enter Valid choice");
                                    }
                                }
                            }
                        } else if (choice3 == 7){
                            System.out.println("Exiting Bread Making Menu");
                            break;
                        }
                    }
                    break;
                case 3:
                    Counter counter = new Counter(breadInventory, scanner);
                    counter.startCounter(); // Ensure this method is called correctly
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }
}