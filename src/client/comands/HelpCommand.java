package client.comands;

import client.CommandManager;
import system.UserConsole;

import java.util.Scanner;

public class HelpCommand implements BaseCommand{
    private final String name = "help";

    @Override
    public void execute(String[] str) {
        Scanner sc = new Scanner(System.in);
        UserConsole console = new UserConsole(sc);
        CommandManager manager = new CommandManager(sc);
        manager.getAllCommands().forEach((name,command) -> console.printLine(name  + ": " + command.descr()));
    }

    @Override
    public String descr() {
        return "Показывает описание для каждой команды";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
