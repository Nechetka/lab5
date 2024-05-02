package model.UserCreators;

import exceptions.ConsoleReadExceptions;
import model.Chapter;
import model.checkers.ChapterMarineCountChecker;
import model.checkers.NameChecker;
import system.Utils;


import java.util.InputMismatchException;

public class ChapterCreator implements BaseObjectUserCreator<Chapter> {

    @Override
    public Chapter create() {
        Chapter chapter = new Chapter();
        System.out.println("Начинаем создание объекта класса Chapter:");
        while (true) {
            try {
                System.out.println("Введите значение name (тип String,значение не null и не пустое)");
                String line = "";
                var nameCheck = new NameChecker();
                line = Utils.consoleReader();
                if (nameCheck.check(line)) {
                    chapter.setName(line);
                } else {
                    System.out.println("Значение строки должно быть не пустым и не null. Попробуйте заново.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неправильный ввод строки. Попробуйте заново.");
                continue;
            }catch (ConsoleReadExceptions e){
                System.out.println(e.getMessage()+" Попробуйте заново.");
                continue;
            }
            break;
        }
        while (true) {
            try {
                System.out.println("Введите значение parentLegion (тип String)");
                String name;
                name = Utils.consoleReader();
                chapter.setParentLegion(name);
            } catch (InputMismatchException e) {
                System.out.println("Неправильный ввод строки. Попробуйте заново.");
                continue;
            } catch (ConsoleReadExceptions e){
            System.out.println(e.getMessage()+" Попробуйте заново.");
            continue;
        }
            break;
        }
        while (true) {
            try {
                System.out.println("Введите значение marineCount (тип Integer,значение больше 0, максимальное значение: 1000)");
                int value = 0;
                var countCheck = new ChapterMarineCountChecker();
                String line = Utils.consoleReader();
                if (line!=null)
                    value = Integer.parseInt(line);
                else {
                    System.out.println("Значение числа должно быть не null. Попробуйте заново.");
                    continue;
                }
                if (countCheck.check(value)) {
                    chapter.setMarineCount(value);
                } else {
                    System.out.println("Значение числа должно быть целым больше 0 и не больше 1000. Попробуйте заново.");
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
                System.out.println("Введите значение world (тип String,значение не null)");
                String line = Utils.consoleReader();
                if (line!=null) {
                    chapter.setWorld(line);
                } else {
                    System.out.println("Значение числа должно быть не null. Попробуйте заново.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод числа. Попробуйте заново.");
                continue;
            }catch (ConsoleReadExceptions e){
                System.out.println(e.getMessage()+" Попробуйте заново.");
                continue;
            }
            break;
        }
        System.out.println("Обьект Chapter успешно создан!");
        return chapter;
    }
}
