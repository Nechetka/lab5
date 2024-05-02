package model.Creators.NonUSerCreators;

import exceptions.CreateObjectException;
import model.Chapter;
import model.Creators.BaseObjectUserCreator;
import model.checkers.ChapterMarineCountChecker;
import model.checkers.NameChecker;
import system.UserConsole;
import java.util.Scanner;

public class ChapterNonUserCreator implements BaseObjectUserCreator<Chapter> {
    private final Scanner out;
    public ChapterNonUserCreator (Scanner scanner){
        out = scanner;
    }
    @Override
    public Chapter create() throws CreateObjectException {
        Chapter chapter = new Chapter();
        UserConsole console = new UserConsole(out);
        try {
            var nameCheck = new NameChecker();
            String line = console.read();
            if (nameCheck.check(line)) {
                chapter.setName(line);
            } else {
                throw new CreateObjectException("Значение строки должно быть не пустым и не null.");
            }
            String name = console.read();
            chapter.setParentLegion(name);
            var countCheck = new ChapterMarineCountChecker();
            line = console.read();
            int value = Integer.parseInt(line);
            if (countCheck.check(value)) {
                chapter.setMarineCount(value);
            } else {
                throw new CreateObjectException("Значение числа должно быть целым больше 0 и не больше 1000.");
            }
            line = console.read();
            if (line != null) {
                chapter.setWorld(line);
            } else {
                throw new CreateObjectException("Значение строки должно быть не пустым и не null.");
            }
            return chapter;
        } catch (Exception e){
            throw new CreateObjectException(e.getMessage());
        }
    }
}
