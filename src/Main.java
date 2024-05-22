
import client.Invoker;
import exceptions.InvokerException;
import fileManipulation.ReadFromFileObject;
import fileManipulation.ReadJSONCollection;
import model.SpaceMarine;
import system.SpaceMarinesManager;
import system.UserConsole;
import system.Utils;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Utils.setEnv("Lab5");
        Invoker invoker = new Invoker();
        UserConsole console = new UserConsole(new Scanner(System.in));
        SpaceMarinesManager marineManager = SpaceMarinesManager.getInstance();
        ReadFromFileObject<TreeSet<SpaceMarine>> reader = new ReadJSONCollection();
        console.printLine(System.getenv(Utils.getEnv()));
        TreeSet<SpaceMarine> marines = reader.read(System.getenv(Utils.getEnv())+"/SpaceMarines.json");
        marineManager.setCollection(marines);
        while (true){
            try {
                invoker.startToInvoke(new InputStreamReader(System.in));
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    {
                        System.out.println("Получен сигнал завершения работы (Ctrl+D).");
                        System.out.println("Закрываем программу");
                        System.exit(1);
                    }
                    @Override
                    public void run() {
                    } } );
            } catch (InvokerException e){
                console.printLine(e.getMessage());
            }
        }


    }
}