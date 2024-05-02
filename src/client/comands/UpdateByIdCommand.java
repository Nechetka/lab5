package client.comands;

import exceptions.CreateObjectException;
import exceptions.WrongValuesOfCommandArgumentException;
import model.Creators.BaseObjectUserCreator;
import model.SpaceMarine;
import system.SpaceMarinesManager;
import system.UserConsole;
import system.Utils;

import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class UpdateByIdCommand implements BaseCommand {
    private final BaseObjectUserCreator<SpaceMarine> builder;
    public  UpdateByIdCommand (BaseObjectUserCreator<SpaceMarine> creator){
        this.builder = creator;
    }
    private final String name = "update";
    @Override
    public void execute(String[] str) throws WrongValuesOfCommandArgumentException, CreateObjectException {
        SpaceMarinesManager colMan = SpaceMarinesManager.getInstance();
        TreeSet<SpaceMarine> coll = colMan.getCollection();
        Utils.checkArgumentsOrThrow(str.length,1);
        UserConsole console = new UserConsole(new Scanner(System.in));
        long id;
        try{
            id = Long.parseLong(str[1]);
            if(!coll.removeIf(marine -> Objects.equals(marine.getId(), id)))
            {
                console.printLine("Элемента с таким Id коллекции нет");
            }
            else{
                SpaceMarine updateMarine = builder.create();
                updateMarine.setId(id);
                coll.add(updateMarine);
                colMan.setCollection(coll);
            }
        } catch (NumberFormatException e) {
            console.printLine("Неправильный ввод значения Id. Попробуйте заново.");
        }

    }

    @Override
    public String descr() {
        return "Обновляет элемент, Id которого равен указанному.\n" +
                "   Аргумент команды: Id;    Тип: Long";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
