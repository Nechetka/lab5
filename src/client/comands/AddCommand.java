package client.comands;

import exceptions.CreateObjectException;
import model.Creators.BaseObjectUserCreator;
import model.SpaceMarine;
import system.CollectionReceiver;
import system.SpaceMarinesManager;
import java.util.TreeSet;
public class AddCommand implements BaseCommand{
    private final String name = "add";
    private final BaseObjectUserCreator<SpaceMarine> builder;
    public  AddCommand (BaseObjectUserCreator<SpaceMarine> creator){
        this.builder = creator;
    }

    @Override
    public void execute(String[] str) throws CreateObjectException {
        CollectionReceiver<TreeSet<SpaceMarine>, SpaceMarine> colMan = SpaceMarinesManager.getInstance();
        colMan.addElementToCollection(builder.create());
    }

    @Override
    public String descr() {
        return "Добавляет объект в коллекцию";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
