package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

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
        dc.addNewDishInMenu(dishType, dishName); // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        ArrayList<String> typesForCombos = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                typesForCombos.add(nextItem);
            } else {
                System.out.println("Несуществующий тип, введите другой тип.");
            }
            nextItem = scanner.nextLine();
        }
        if (typesForCombos.isEmpty()) {
            System.out.println("ВЫ не ввели типы блюд, для создания комбинаций");
        } else {
            dc.generateCombos(numberOfCombos, typesForCombos); // сгенерируйте комбинации блюд и выведите на экран
        }
        System.out.println("--------\n");  // разделение списка от меню
    }
}
