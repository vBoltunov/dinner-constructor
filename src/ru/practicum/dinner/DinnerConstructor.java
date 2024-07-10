package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByTypes;
    ArrayList<String> typesOfRequiredDishes;
    ArrayList<String> first = new ArrayList<>();
    ArrayList<String> second = new ArrayList<>();
    ArrayList<String> third = new ArrayList<>();


    public DinnerConstructor() {
        dishesByTypes = new HashMap<>();
        typesOfRequiredDishes = new ArrayList<>();
    }

    void addDishesByType(String dishType, String dishName) {
        if (checkType(dishType)) {
            ArrayList<String> dishes = dishesByTypes.get(dishType);
            dishes.add(dishName);

        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesByTypes.put(dishType, dishes);
        }
    }

    void generateDishesCombos(Integer numberOfCombos) {
        HashMap<String, ArrayList<String>> dishesCombos = new HashMap<>();
        first.add("Суп");
        first.add("Борщ");
        first.add("Солянка");
        second.add("Курица");
        second.add("Мясо");
        second.add("Плов");
        third.add("Сок");
        third.add("Чай");
        third.add("Кофе");

        dishesByTypes.put("Первое", first);
        dishesByTypes.put("Второе", second);
        dishesByTypes.put("Напиток", third);

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> dishes;
            ArrayList<String> randomDishes = new ArrayList<>();
            for (int j = 0; j < dishesByTypes.size(); j++) {
                String typeOfRequiredDish = typesOfRequiredDishes.get(j);
                dishes = dishesByTypes.get(typeOfRequiredDish);
                String randomDish = dishes.get(generateRandomNumber(dishes.size()));
                randomDishes.add(randomDish);
            }
            dishesCombos.put("Комбо " + (i + 1), randomDishes);
        }
        for (String dishesCombo : dishesCombos.keySet()) {
            ArrayList<String> combos = dishesCombos.get(dishesCombo);
            System.out.println(dishesCombo);
            for (String combo : combos) {
                System.out.println(combo);
            }
        }
    }

    Integer generateRandomNumber(Integer max) {
//        return (int) Math.round(Math.random() * max);
        return (int) Math.round(Math.random() * max);
    }

    boolean checkType(String dishType) {
        return dishesByTypes.containsKey(dishType);
    }
}
