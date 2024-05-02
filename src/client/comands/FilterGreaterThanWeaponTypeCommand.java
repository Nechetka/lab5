package client.comands;

import exceptions.WrongValuesOfCommandArgumentException;
import model.SpaceMarine;
import model.Weapon;
import system.SpaceMarinesManager;
import system.UserConsole;
import system.Utils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class FilterGreaterThanWeaponTypeCommand implements BaseCommand{
    private final String name = "filter_greater_than_weapon_type";

    @Override
    public void execute(String[] str) throws WrongValuesOfCommandArgumentException {
        TreeSet<SpaceMarine> coll = SpaceMarinesManager.getInstance().getCollection();
        Utils.checkArgumentsOrThrow(str.length, 1);
        UserConsole console = new UserConsole(new Scanner(System.in));
        try {
            Weapon weapon = Weapon.valueOf(str[1]);
            if (coll.isEmpty()) {
                console.printLine("В коллекции нет объектов");
            } else {
                coll.stream().filter(obj -> weapon.ordinal() < obj.getWeaponType().ordinal()).forEach(obj -> console.printLine(obj.toString()));
            }
        } catch (IllegalArgumentException | EnumConstantNotPresentException e) {
            console.printLine("Нет такой переменной. Попробуйте заново.");
        }
    }

    @Override
    public String descr() {
        var weapons = Arrays.toString(Weapon.values());
        return "Выводит все элементы коллекции, значение поля weaponType которых больше заданного\n" +
                "   Возможные аргументы команды: "+weapons+";    Тип: Weapon";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
