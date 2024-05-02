package client.comands;

import exceptions.CreateObjectException;
import exceptions.WrongValuesOfCommandArgumentException;
import model.Creators.BaseObjectUserCreator;
import model.SpaceMarine;
import system.SpaceMarinesManager;

import java.util.TreeSet;

public class RemoveLowerCommand implements BaseCommand{
    private final String name = "remove_lower";
    private final BaseObjectUserCreator<SpaceMarine> builder;
    public  RemoveLowerCommand (BaseObjectUserCreator<SpaceMarine> creator){
        this.builder = creator;
    }
    @Override
    public void execute(String[] str) throws WrongValuesOfCommandArgumentException, CreateObjectException {
        TreeSet<SpaceMarine> coll = SpaceMarinesManager.getInstance().getCollection();
        SpaceMarine newMarine = builder.create();
        coll.removeIf(marine -> newMarine.getHealth() > marine.getHealth());
    }

    @Override
    public String descr() {
        return "Удаляет элементы, меньшие заданного";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
