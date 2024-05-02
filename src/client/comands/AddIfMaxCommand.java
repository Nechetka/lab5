package client.comands;

import exceptions.CreateObjectException;
import model.Creators.BaseObjectUserCreator;
import model.SpaceMarine;
import model.comparators.MarineHealthComparator;
import system.SpaceMarinesManager;
import system.UserConsole;

import java.util.Comparator;
import java.util.Scanner;

public class AddIfMaxCommand implements BaseCommand{
    private final String name = "add_if_max";
    private final BaseObjectUserCreator<SpaceMarine> builder;
    public  AddIfMaxCommand (BaseObjectUserCreator<SpaceMarine> creator){
        this.builder = creator;
    }
    @Override
    public void execute(String[] str) throws CreateObjectException {
        SpaceMarinesManager colMan = SpaceMarinesManager.getInstance();
        SpaceMarine newMarine = builder.create();
        Comparator<SpaceMarine> comp = new MarineHealthComparator();
        UserConsole console = new UserConsole(new Scanner(System.in));
        if(colMan.getMaxElement(comp).getHealth()>= newMarine.getHealth())
        {
            console.printLine("Введенный элемент был не максимальный.");
        }
        else{
            colMan.addElementToCollection(newMarine);
        }
    }

    @Override
    public String descr() {
        return "Добавляет введеный элемент, если он максимальный (по значению поля health)";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
