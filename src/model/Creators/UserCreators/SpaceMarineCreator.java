package model.Creators.UserCreators;

import exceptions.ConsoleReadException;
import model.AstartesCategory;
import model.Creators.BaseObjectUserCreator;
import model.SpaceMarine;
import model.Weapon;
import model.checkers.MarineHealthChecker;
import model.checkers.NameChecker;
import system.UserConsole;
import system.Utils;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class SpaceMarineCreator implements BaseObjectUserCreator<SpaceMarine> {
    private Date initDate;
    private final Scanner out;
    public SpaceMarineCreator (){
        out = new Scanner(System.in);
    }
    @Override
    public SpaceMarine create() {
        SpaceMarine marine = new SpaceMarine();
        initDate = Date.from(Instant.now());
        marine.setCreationDate(initDate);
        UserConsole console = new UserConsole(out);
        console.printLine("Начинаем создание объекта класса SpaceMarine:");
        marine.setId(Utils.getNewId());
        while(true){
            try {
                console.printLine("Введите значение name (тип String,значение не null и не пустое)");
                String line = console.read();
                var nameCheck = new NameChecker();
                if (nameCheck.check(line)) {
                    marine.setName(line);
                } else {
                    console.printLine("Значение строки должно быть не пустым и не null. Попробуйте заново.");
                    continue;
                }
            } catch (ConsoleReadException e) {
                console.printLine(e.getMessage()+" Попробуйте заново.");
                continue;
            }
            break;
        }
        var cordCreator = new CoordinatesCreator();
        marine.setCoordinates(cordCreator.create());
        while (true) {
            try {
                var healthCheck = new MarineHealthChecker();
                console.printLine("Введите значение Health (тип dooble ,значение больше 0)");
                double value = 0;
                String line = console.read();
                if (line!=null)
                    value = Double.parseDouble(line);
                else {
                    console.printLine("Значение числа должно быть не null. Попробуйте заново.");
                    continue;
                }
                if (healthCheck.check(value)) {
                    marine.setHealth(value);
                }
                else{
                    console.printLine("Значение числа должно быть >0. Попробуйте заново.");
                    continue;
                }
            } catch (NumberFormatException e) {
                console.printLine("Неправильный ввод числа. Попробуйте заново.");
                continue;
            } catch (ConsoleReadException e){
            console.printLine(e.getMessage()+" Попробуйте заново.");
            continue;
        }
            break;
        }
        while (true) {
            try {
                Boolean loyal = null;
                console.printLine("Введите значение Loyal (тип Boolean ,значение не null)");
                String line = console.read();
                if (line != null)
                    loyal = Boolean.valueOf(line);
                else {
                    console.printLine("Значение числа должно быть не null. Попробуйте заново.");
                    continue;
                }
                marine.setLoyal(loyal);
            }catch (ConsoleReadException e){
                    console.printLine(e.getMessage()+" Попробуйте заново.");
                    continue;
                }
            break;
        }
        var categories = Arrays.toString(AstartesCategory.values());
        while (true) {
            try {
                AstartesCategory cat;
                console.printLine("Введите одно из значений AstartesCategory на выбор из предложенных:");
                console.printLine(categories);
                String line = console.read();
                if (line!=null)
                    cat = AstartesCategory.valueOf(line);
                else {
                    console.printLine("Строка не должна быть null. Попробуйте заново.");
                    continue;
                }
                marine.setCategory(cat);
            } catch (IllegalArgumentException|EnumConstantNotPresentException e) {
                console.printLine("Нет такой переменной. Попробуйте заново.");
                continue;
            }catch (ConsoleReadException e){
                console.printLine(e.getMessage()+" Попробуйте заново.");
                continue;
            }
            break;
        }
        var weapons = Arrays.toString(Weapon.values());
        while (true) {
            try {
                Weapon weapon;
                console.printLine("Введите одно из значений Weapon на выбор из предложенных:");
                console.printLine(weapons);
                String line = console.read();
                if (line!=null)
                    weapon = Weapon.valueOf(line);
                else {
                    console.printLine("Строка не должна быть null. Попробуйте заново.");
                    continue;
                }
                marine.setWeaponType(weapon);
            } catch (IllegalArgumentException|EnumConstantNotPresentException e) {
                console.printLine("Нет такой переменной. Попробуйте заново.");
                continue;
            }catch (ConsoleReadException e){
                console.printLine(e.getMessage()+" Попробуйте заново.");
                continue;
            }
            break;
        }
        var chapterCreator = new ChapterCreator();
        marine.setChapter(chapterCreator.create());
        console.printLine("Обьект SpaceMarine успешно создан!");
        return marine;
    }
}
