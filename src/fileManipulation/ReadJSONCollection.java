package fileManipulation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.SpaceMarine;
import system.UserConsole;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Scanner;
import java.util.TreeSet;

public class ReadJSONCollection implements ReadFromFileObject<TreeSet<SpaceMarine>> {
    @Override
    public TreeSet<SpaceMarine> read(String path) {
        Gson gson = new Gson();
        Type type = new TypeToken<TreeSet<SpaceMarine>>() {
        }.getType();
        UserConsole console = new UserConsole(new Scanner(System.in));
        console.printLine(path);
        TreeSet<SpaceMarine> marines = new TreeSet<SpaceMarine>();
        try {
            Reader file = new FileReader(path);
            marines = gson.fromJson(file, type);
            return marines;
        } catch (FileNotFoundException e) {
            console.printLine("Предыдущий файл не был найден или его вообще не существовало.");
            return marines;
        }
    }
}
