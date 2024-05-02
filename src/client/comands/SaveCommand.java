package client.comands;

import fileManipulation.WriteJSONCollection;
import fileManipulation.WriteToObject;
import model.SpaceMarine;
import system.SpaceMarinesManager;
import system.UserConsole;
import system.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class SaveCommand implements BaseCommand{
    private final String name = "save";
    @Override
    public void execute(String[] str) throws FileNotFoundException{
        TreeSet<SpaceMarine> coll = SpaceMarinesManager.getInstance().getCollection();
        WriteToObject<TreeSet<SpaceMarine>> saver = new WriteJSONCollection<>();
        UserConsole console = new UserConsole(new Scanner(System.in));
        String path = System.getenv(Utils.getEnv());
        try {
            saver.write(path, coll);
        } catch (IOException e){
            console.printLine("Неопознанная ошибка работы с файлами. Проверьте права доступа к файлу и повторите.\n"+"Ошибка: "+e.getMessage());
        }

    }

    @Override
    public String descr() {
        return "Сохраняет коллекцию в файл";
    }

    @Override
    public String getName() {
        return name;
    }
}
