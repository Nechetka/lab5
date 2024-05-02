package model.Creators.NonUSerCreators;

import exceptions.CreateObjectException;
import model.AstartesCategory;
import model.Coordinates;
import model.Creators.BaseObjectUserCreator;
import model.SpaceMarine;
import model.Weapon;
import model.checkers.Checked;
import model.checkers.MarineHealthChecker;
import model.checkers.NameChecker;
import system.UserConsole;
import system.Utils;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class SpaceMarineNonUserCreator implements BaseObjectUserCreator<SpaceMarine> {
    private Date initDate;
    private final Scanner out;
    public SpaceMarineNonUserCreator (Scanner scanner){
        out = scanner;
    }
    @Override
    public SpaceMarine create() throws CreateObjectException {
        try {
            SpaceMarine marine = new SpaceMarine();
            initDate = Date.from(Instant.now());
            marine.setCreationDate(initDate);
            UserConsole console = new UserConsole(out);
            marine.setId(Utils.getNewId());
            String line = console.read();
            Checked<String> nameCheck = new NameChecker();
            if (nameCheck.check(line)) {
                marine.setName(line);
            } else {
                throw new CreateObjectException("Значение строки должно быть не пустым и не null.");
            }
            BaseObjectUserCreator<Coordinates> cordCreator = new CoordinatesNonUserCreator(out);
            marine.setCoordinates(cordCreator.create());
            Checked<Double> healthCheck = new MarineHealthChecker();
            line = console.read();
            double value = Double.parseDouble(line);
            if (healthCheck.check(value)) {
                marine.setHealth(value);
            } else {
                throw new CreateObjectException("Значение числа должно быть >0.");
            }
            line = console.read();
            boolean loyal = Boolean.getBoolean(line);
            marine.setLoyal(loyal);
            line = console.read();
            AstartesCategory cat = AstartesCategory.valueOf(line);
            marine.setCategory(cat);
            line = console.read();
            Weapon weapon = Weapon.valueOf(line);
            marine.setWeaponType(weapon);
            var chapterCreator = new ChapterNonUserCreator(out);
            marine.setChapter(chapterCreator.create());
            console.printLine("Обьект SpaceMarine успешно создан!");
            return marine;
        } catch (Exception e) {
            throw new CreateObjectException(e.getMessage());
        }
    }
}
