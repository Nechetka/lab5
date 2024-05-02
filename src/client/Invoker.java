package client;

import exceptions.CommandManagerException;
import exceptions.ConsoleReadException;
import exceptions.InvokerException;
import system.UserConsole;

import java.util.Scanner;

public class Invoker {
    public void startToInvoke (Readable inObj) throws InvokerException {
        Scanner in = new Scanner(inObj);
        UserConsole console = new UserConsole(in);
        CommandManager com = new CommandManager(in);
        while (in.hasNextLine()) {
            try {
                String line = console.read();
                com.executer(line);
            } catch (ConsoleReadException | CommandManagerException e) {
                throw  new InvokerException("Ошибка: "+e.getMessage());
            }
        }
    }

}
