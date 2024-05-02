package client.comands;

import model.SpaceMarine;
import system.SpaceMarinesManager;
import system.UserConsole;

import java.util.Scanner;
import java.util.TreeSet;

public class ShowCommand implements BaseCommand{
    private final String name = "show";

    @Override
    public void execute(String[] str) {
        TreeSet<SpaceMarine> coll = SpaceMarinesManager.getInstance().getCollection();
        UserConsole console = new UserConsole(new Scanner(System.in));
        if (coll.isEmpty()){
            console.printLine("В коллекции нет объектов");
        } else {
            coll.forEach(obj -> console.printLine(obj.toString()));
        }
    }

    @Override
    public String descr() {
        return "Выводит все элементы коллекции в строковом представлении";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
