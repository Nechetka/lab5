package client.comands;

import exceptions.CreateObjectException;
import exceptions.WrongValuesOfCommandArgumentException;

import java.io.FileNotFoundException;

public interface BaseCommand {
    public void execute (String[] str) throws WrongValuesOfCommandArgumentException, CreateObjectException, FileNotFoundException;
    public String descr();
    public String getName();
}
