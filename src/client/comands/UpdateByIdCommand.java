package client.comands;

import exceptions.WrongValuesOfCommandArgumentException;
import system.SpaceMarinesManager;
import system.Utils;

import java.util.Objects;

public class UpdateIdCommand implements BaseCommand {
    @Override
    public void execute(String[] str) throws WrongValuesOfCommandArgumentException {
        var coll = SpaceMarinesManager.getInstance().getCollection();
        Utils.checkArgumentsOrThrow(str.length,1);
        int id;
        try{
            id = Integer.parseInt(str[1]);
            if(!coll.removeIf(marine -> Objects.equals(marine.getId(), id)))
            {
                System.out.println("Element with that id doesn't exists.");
            }
            else{

            }
        } catch (NumberFormatException e) {
            System.out.println("Неправильный ввод числа. Попробуйте заново.");
        }

    }

    @Override
    public String descr() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
