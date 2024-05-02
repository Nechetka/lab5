package client.comands;

import client.Invoker;
import exceptions.InvokerException;
import exceptions.WrongValuesOfCommandArgumentException;
import model.SpaceMarine;
import system.SpaceMarinesManager;
import system.UserConsole;
import system.Utils;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.TreeSet;

public class ExecuteScriptCommand implements BaseCommand {
    private final String name = "execute_script";
    private static ArrayDeque<Path> openScriptDeque = new ArrayDeque<>();


    @Override
    public void execute(String[] str) throws WrongValuesOfCommandArgumentException {
        UserConsole console = new UserConsole(new Scanner(System.in));
        SpaceMarinesManager manager = SpaceMarinesManager.getInstance();
        TreeSet<SpaceMarine> untouchedCollection = manager.getCollection();
        Invoker invoker = new Invoker();
        Utils.checkArgumentsOrThrow(str.length, 1);
        Path path = Path.of(str[1]);
        try {
            if (openScriptDeque.contains(path)){
                System.out.println("Найдена рекурсия! Файл "+path+" пропущен.");
                manager.setCollection(untouchedCollection);
                return;
            }
            BufferedReader input = new BufferedReader(new FileReader(path.toFile()));
            UserConsole.onScriptMode();
            openScriptDeque.addLast(path);
            invoker.startToInvoke(input);
            openScriptDeque.removeLast();
            UserConsole.onUserMode();
        } catch (InvokerException e) {
            openScriptDeque.removeLast();
            UserConsole.onUserMode();
            console.printLine("Ошибки во время исполнения команд скрипта. Подробнее:\n" + e.getMessage());
            manager.setCollection(untouchedCollection);
        } catch (FileNotFoundException e ){
            console.printLine("Файл скрипта не найден.");
            manager.setCollection(untouchedCollection);
        }
    }

    @Override
    public String descr() {
        return "Вызывает скрипт из файла";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
