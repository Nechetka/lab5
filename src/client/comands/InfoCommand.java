package client.comands;


import system.SpaceMarinesManager;
import system.UserConsole;

import java.util.Scanner;

public class InfoCommand implements BaseCommand{
    private final String name = "info";

    @Override
    public void execute(String[] str) {
        var colMan = SpaceMarinesManager.getInstance();
        UserConsole console = new UserConsole(new Scanner(System.in));
        console.printLine("Тип коллекции: "+colMan.getCollection().getClass());
        console.printLine("Дата создания: "+colMan.getInitDate().toString());
        console.printLine("Количество элементов: "+colMan.getSize());
    }

    @Override
    public String descr() {
        return "Показывает информацию о коллекции(тип, дату создания, количество элементов)";
    }

    @Override
    public String getName() {
        return this.name;
    }
}

