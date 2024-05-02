package client.comands;

import exceptions.WrongValuesOfCommandArgumentException;
import model.SpaceMarine;
import system.SpaceMarinesManager;
import system.UserConsole;
import system.Utils;

import java.util.Scanner;
import java.util.TreeSet;

public class FilterByHealthCommand implements BaseCommand {
    private final String name = "filter_greater_than_weapon_type";

    @Override
    public void execute(String[] str) throws WrongValuesOfCommandArgumentException {
        TreeSet<SpaceMarine> coll = SpaceMarinesManager.getInstance().getCollection();
        Utils.checkArgumentsOrThrow(str.length, 1);
        UserConsole console = new UserConsole(new Scanner(System.in));
        try {
            double health =  Double.parseDouble(str[1]);
            if (coll.isEmpty()) {
                console.printLine("В коллекции нет объектов");
            } else {
                coll.stream().filter(obj -> health==obj.getHealth()).forEach(obj -> console.printLine(obj.toString()));
            }
        } catch (NumberFormatException e) {
            console.printLine("Не правильный ввод переменной health. Попробуйте заново.");
        }
    }

    @Override
    public String descr() {
        return "Выводит все элементы коллекции, значение поля health которых равно заданному.\n" +
                "   Аргумент команды: health;    Тип: double";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
