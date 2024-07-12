package ru.practicum.dinner;

import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static int numberOfCombos;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        // добавьте новое блюдо
        dc.addDishesByType(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        String nextInput = scanner.next();
        while (!dc.isInteger(nextInput)) {
                System.out.print("Вы ввели не число! Попробуйте ещё раз: ");
                nextInput = scanner.next();
        }
        numberOfCombos = Integer.parseInt(nextInput);
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку");

        System.out.println("Доступные типы блюд: " + dc.dishesInStockByTypes.keySet());

        String nextItem = scanner.nextLine();

        while (!nextItem.isEmpty()) {
            if (!dc.isDishTypeExist(nextItem)) {
                System.out.println("Такого типа блюда пока нет!");
                System.out.println("Доступные типы блюд: " + dc.dishesInStockByTypes.keySet());
            } else {
                dc.requestedTypesOfDishes.add(nextItem);
            }
            nextItem = scanner.nextLine();
        }

        // генерируем комбинации блюд и выводим на экран
        dc.generateDishesCombos(numberOfCombos);
        dc.printDishesCombos();
    }
}
