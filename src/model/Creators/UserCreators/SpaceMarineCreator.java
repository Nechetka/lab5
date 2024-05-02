package model.UserCreators;

import exceptions.ConsoleReadExceptions;
import model.AstartesCategory;
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
    private static long id = 1l;
    private Date initDate;
    private final Scanner out;
    public SpaceMarineCreator (Scanner sc){
        out = sc;
    }
    @Override
    public SpaceMarine create() {
        SpaceMarine marine = new SpaceMarine();
        initDate = Date.from(Instant.now());
        marine.setCreationDate(initDate);
        UserConsole console = new UserConsole(out);
        console.printLine("Начинаем создание объекта класса SpaceMarine:");
        marine.setId(id);
        id+=1;
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
            } catch (ConsoleReadExceptions e) {
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
                System.out.println("Введите значение Health (тип dooble ,значение больше 0)");
                double value = 0;
                String line = Utils.consoleReader();
                if (line!=null)
                    value = Double.parseDouble(line);
                else {
                    System.out.println("Значение числа должно быть не null. Попробуйте заново.");
                    continue;
                }
                if (healthCheck.check(value)) {
                    marine.setHealth(value);
                }
                else{
                    System.out.println("Значение числа должно быть >0. Попробуйте заново.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод числа. Попробуйте заново.");
                continue;
            } catch (ConsoleReadExceptions e){
            System.out.println(e.getMessage()+" Попробуйте заново.");
            continue;
        }
            break;
        }
        while (true) {
            try {
                Boolean loyal = null;
                System.out.println("Введите значение Loyal (тип Boolean ,значение не null)");
                String line = Utils.consoleReader();
                if (line != null)
                    loyal = Boolean.getBoolean(line);
                else {
                    System.out.println("Значение числа должно быть не null. Попробуйте заново.");
                    continue;
                }
                marine.setLoyal(loyal);
            }catch (ConsoleReadExceptions e){
                    System.out.println(e.getMessage()+" Попробуйте заново.");
                    continue;
                }
            break;
        }
        var categories = Arrays.toString(AstartesCategory.values());
        while (true) {
            try {
                AstartesCategory cat;
                System.out.println("Введите одно из значений AstartesCategory на выбор из предложенных:");
                System.out.println(categories);
                String line = Utils.consoleReader();
                if (line!=null)
                    cat = AstartesCategory.valueOf(line);
                else {
                    System.out.println("Строка не должна быть null. Попробуйте заново.");
                    continue;
                }
                marine.setCategory(cat);
            } catch (IllegalArgumentException|EnumConstantNotPresentException e) {
                System.out.println("Нет такой переменной. Попробуйте заново.");
                continue;
            }catch (ConsoleReadExceptions e){
                System.out.println(e.getMessage()+" Попробуйте заново.");
                continue;
            }
            break;
        }
        var weapons = Arrays.toString(Weapon.values());
        while (true) {
            try {
                Weapon weapon;
                System.out.println("Введите одно из значений Weapon на выбор из предложенных:");
                System.out.println(weapons);
                String line = Utils.consoleReader();
                if (line!=null)
                    weapon = Weapon.valueOf(line);
                else {
                    System.out.println("Строка не должна быть null. Попробуйте заново.");
                    continue;
                }
                marine.setWeaponType(weapon);
            } catch (IllegalArgumentException|EnumConstantNotPresentException e) {
                System.out.println("Нет такой переменной. Попробуйте заново.");
                continue;
            }catch (ConsoleReadExceptions e){
                System.out.println(e.getMessage()+" Попробуйте заново.");
                continue;
            }
            break;
        }
        var chapterCreator = new ChapterCreator();
        marine.setChapter(chapterCreator.create());
        System.out.println("Обьект SpaceMarine успешно создан!");
        return marine;
    }
}
