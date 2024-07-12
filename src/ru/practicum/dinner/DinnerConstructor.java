package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesInStockByTypes;
    ArrayList<ArrayList<String>> dishesCombos;
    ArrayList<String> requestedTypesOfDishes;
    Random randomDishIndex = new Random();

    public DinnerConstructor() {
        dishesInStockByTypes = new HashMap<>();
        requestedTypesOfDishes = new ArrayList<>();
        dishesCombos = new ArrayList<>();
    }

    void addDishesByType(String dishType, String dishName) {
        if (isDishTypeExist(dishType)) {
            ArrayList<String> dishes = dishesInStockByTypes.get(dishType);
            dishes.add(dishName);

        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesInStockByTypes.put(dishType, dishes);
        }
    }

    void generateDishesCombos(Integer numberOfCombos) {

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> comboOfRandomDishes = new ArrayList<>();
            for (String typeOfRequiredDish : requestedTypesOfDishes) {
                ArrayList<String> dishesInStock = dishesInStockByTypes.get(typeOfRequiredDish);
                String randomDish = dishesInStock.get(randomDishIndex.nextInt(dishesInStock.size()));
                comboOfRandomDishes.add(randomDish);
            }
            dishesCombos.add(i, comboOfRandomDishes);
        }
    }

    void printDishesCombos() {
        System.out.println("Мы можем предложить вам следующие комбо из выбранных типов блюд:");
        for (int i = 0; i < dishesCombos.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(dishesCombos.get(i));
        }
        System.out.println();
    }

    boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean isDishTypeExist(String dishType) {
        return dishesInStockByTypes.containsKey(dishType);
    }
}
