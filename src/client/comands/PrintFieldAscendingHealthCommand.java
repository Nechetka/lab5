package client.comands;

import model.SpaceMarine;
import model.comparators.MarineHealthComparator;
import system.SpaceMarinesManager;
import system.UserConsole;

import java.util.Comparator;
import java.util.Scanner;

public class PrintFieldAscendingHealthCommand implements BaseCommand {
    private final String name = "print_fields_ascending_health";

    @Override
    public void execute(String[] str) {
        SpaceMarinesManager colMan = SpaceMarinesManager.getInstance();
        Comparator<SpaceMarine> healthComp = new MarineHealthComparator();
        UserConsole console = new UserConsole(new Scanner(System.in));
        colMan.getCollection().stream().sorted(healthComp).forEach(obj -> console.print(obj.getHealth()+" "));
        console.print("\n");
    }

    @Override
    public String descr() {
        return "Выводит значение поля Health всех элементов в порядке возрастания";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
