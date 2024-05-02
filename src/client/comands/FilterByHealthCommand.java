package client.comands;

import exceptions.WrongValuesOfCommandArgumentException;
import model.Weapon;
import system.SpaceMarinesManager;
import system.Utils;

public class FilterByHealth {
    private final String name = "filter_greater_than_weapon_type";

    @Override
    public void execute(String[] str) throws WrongValuesOfCommandArgumentException {
        var coll = SpaceMarinesManager.getInstance().getCollection();
        Utils.checkArgumentsOrThrow(str.length, 1);
        try {
            double health =  Double.parseDouble(str[1]);
            if (coll.isEmpty()) {
                System.out.println("В коллекции нет объектов");
            } else {
                coll.stream().filter();
                coll.forEach(System.out::println);
            }
        } catch (NumberFormatException e) {
            System.out.println("Нет такой переменной. Попробуйте заново.");
        }
    }

    @Override
    public String descr() {
        return "Выводит все элементы коллекции, значение поля weaponType которых больше заданного";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
