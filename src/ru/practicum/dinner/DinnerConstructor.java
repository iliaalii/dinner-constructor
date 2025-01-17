package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menuResto = new HashMap<>();

    void addNewDishInMenu(String type, String dish) { // добавьте новое блюдо
        if(checkType(type)) {
            ArrayList<String> listDish = menuResto.get(type);
            listDish.add(dish);
            menuResto.put(type, listDish);
        } else {
            ArrayList<String> listDish = new ArrayList<>();
            listDish.add(dish);
            menuResto.put(type, listDish);
        }
    }

    void generateCombos(int number, ArrayList types) { //генерация комбинаций
        ArrayList<String> typesForCombos = types;


        for (int i = 0; i < number; i++){
            ArrayList<String> comboList = new ArrayList<>();
            for (String type : typesForCombos){
                ArrayList<String> dishList = menuResto.get(type);
                int randomNumber = new Random().nextInt(dishList.size());
                comboList.add(dishList.get(randomNumber));
            }
            System.out.println("Комбо " + i);
            System.out.println(comboList.get(i));
        }
    }

    boolean checkType(String type){
        return menuResto.containsKey(type);
    }
}

