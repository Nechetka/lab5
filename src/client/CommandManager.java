package client;

import client.comands.*;
import exceptions.CommandManagerException;
import exceptions.CreateObjectException;
import exceptions.UnknownCommandException;
import exceptions.WrongValuesOfCommandArgumentException;
import model.Creators.BaseObjectUserCreator;
import model.Creators.NonUSerCreators.SpaceMarineNonUserCreator;
import model.Creators.UserCreators.SpaceMarineCreator;
import model.SpaceMarine;
import system.UserConsole;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Scanner;

public class CommandManager {
    private LinkedHashMap<String, BaseCommand> commands;

    public CommandManager(Scanner scanner)
    {
        this.commands = new LinkedHashMap<>();

        commands.put("exit",new ExitCommand());
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("clear", new ClearCommand());
        commands.put("print_fields_ascending_health", new PrintFieldAscendingHealthCommand());
        commands.put("filter_greater_than_weapon_type", new FilterGreaterThanWeaponTypeCommand());
        commands.put("filter_by_health", new FilterByHealthCommand());
        commands.put("save",new SaveCommand());

        BaseObjectUserCreator<SpaceMarine> marineCreator;
        if (UserConsole.whatsMode()) {
            marineCreator = new SpaceMarineCreator();
        } else {
            marineCreator = new SpaceMarineNonUserCreator(scanner);
        }
        commands.put("add", new AddCommand(marineCreator));
        commands.put("add_if_max", new AddIfMaxCommand(marineCreator));
        commands.put("update", new UpdateByIdCommand(marineCreator));
        commands.put("remove_greater", new RemoveGreaterCommand(marineCreator));
        commands.put("remove_lower", new RemoveLowerCommand(marineCreator));
        commands.put("execute_script",new ExecuteScriptCommand());

    }
    public void executer(String line) throws CommandManagerException {
        try {
            String[] tokens = line.trim().split(" ");
            Optional.ofNullable(commands.get(tokens[0])).orElseThrow(() -> new UnknownCommandException("Указанная команда не была обнаружена.")).execute(tokens);
        }catch (WrongValuesOfCommandArgumentException e){
            throw new CommandManagerException("Не верное колличество аргументов: "+e.getMessage());
        }catch (UnknownCommandException e){
            throw new CommandManagerException(e.getMessage());
        }catch (NullPointerException e) {
            throw new CommandManagerException("Введена пустая строка.");
        } catch (CreateObjectException e) {
            throw new CommandManagerException("Проблемы во время создания объекта: "+e.getMessage());
        } catch (FileNotFoundException e) {
            throw new CommandManagerException("Файл не найден: "+e.getMessage());
        }
    }
    public LinkedHashMap<String,BaseCommand> getAllCommands(){
        return this.commands;
    }
}
