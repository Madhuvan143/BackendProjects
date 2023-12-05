package com.coffee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine {

	private Map<String, Integer> resources;
    private Map<String, Map<String, Integer>> recipes;

    public CoffeeMachine() {
        resources = new HashMap<>();
        resources.put("coffeeBeans", 100);
        resources.put("water", 100);
        resources.put("milk", 100);
        resources.put("sugar", 100);

        recipes = new HashMap<>();
        Map<String, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put("coffeeBeans", 10);
        espressoRecipe.put("water", 50);
        recipes.put("Espresso", espressoRecipe);

        Map<String, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put("coffeeBeans", 10);
        latteRecipe.put("water", 50);
        latteRecipe.put("milk", 30);
        recipes.put("Latte", latteRecipe);

        // Add recipes for other coffee types (e.g., Cappuccino) here.
    }

    public void displayMenu() {
        System.out.println("Coffee Menu:");
        for (String coffeeType : recipes.keySet()) {
            System.out.println(coffeeType);
        }
    }

    public void brewCoffee(String coffeeType) {
        if (!recipes.containsKey(coffeeType)) {
            System.out.println("Invalid coffee type.");
            return;
        }

        Map<String, Integer> recipe = recipes.get(coffeeType);

        for (String ingredient : recipe.keySet()) {
            int requiredAmount = recipe.get(ingredient);
            if (resources.containsKey(ingredient) && resources.get(ingredient) >= requiredAmount) {
                resources.put(ingredient, resources.get(ingredient) - requiredAmount);
            } else {
                System.out.println("Insufficient resources for " + coffeeType);
                return;
            }
        }

        System.out.println("Enjoy your " + coffeeType + "!");
    }

    public void refillResources() {
        for (String ingredient : resources.keySet()) {
            resources.put(ingredient, 100);
        }
        System.out.println("Resources refilled.");
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options: [brew, refill, exit]");
            String option = scanner.nextLine().trim();

            switch (option) {
                case "brew":
                    coffeeMachine.displayMenu();
                    System.out.print("Enter coffee type: ");
                    String coffeeType = scanner.nextLine().trim();
                    coffeeMachine.brewCoffee(coffeeType);
                    break;
                case "refill":
                    coffeeMachine.refillResources();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
