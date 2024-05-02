package client.comands;

import exceptions.WrongValuesOfCommandArgumentException;
import model.SpaceMarine;
import system.SpaceMarinesManager;
import system.UserConsole;
import system.Utils;

import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class RemoveByIdCommand implements BaseCommand{
    private final String name = "remove_by_id";
    @Override
    public void execute(String[] str) throws WrongValuesOfCommandArgumentException {
        SpaceMarinesManager colMan = SpaceMarinesManager.getInstance();
        TreeSet<SpaceMarine> coll = colMan.getCollection();
        UserConsole console = new UserConsole(new Scanner(System.in));
        Utils.checkArgumentsOrThrow(str.length,1);
        long id;
        try{
            id = Long.parseLong(str[1]);
            if(!coll.removeIf(marine -> Objects.equals(marine.getId(), id)))
            {
                console.printLine("Элемента с таким Id коллекции нет");
            }
            else {
                colMan.setCollection(coll);
            }
        } catch (NumberFormatException e) {
            console.printLine("Неправильный ввод Id. Попробуйте заново.");
        }

    }

    @Override
    public String descr() {
        return "Удаляет элемент, Id которого равен указанному.\n" +
                "   Аргумент команды: Id;    Тип: Long";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
