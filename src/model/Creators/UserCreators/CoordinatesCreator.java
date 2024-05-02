package model.UserCreators;

import exceptions.ConsoleReadExceptions;
import model.Coordinates;
import model.checkers.CoordinateYChecker;
import system.Utils;

import java.util.Scanner;

public class CoordinatesCreator implements BaseObjectUserCreator<Coordinates> {
    @Override
    public Coordinates create() {
        Coordinates coordinates = new Coordinates();
        System.out.println("Начинаем создание объекта класса Coordinates:");
        while (true) {
            try {
                System.out.println("Введите значение координаты x (тип Dooble,значение не null)");
                double value=0;
                String line = Utils.consoleReader();
                if (line!= null)
                    value = Double.parseDouble(line);
                else{
                    System.out.println("Значение числа должно быть не null. Попробуйте заново.");
                    continue;
                }
                coordinates.setX(value);
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод числа. Попробуйте заново.");
                continue;
            }catch (ConsoleReadExceptions e){
                System.out.println(e.getMessage()+" Попробуйте заново.");
                continue;
            }
            break;
        }
        while (true) {
            try {
                var Ycheck = new CoordinateYChecker();
                System.out.println("Введите значение координаты y (тип int,значение не больше 58)");
                int value = 0;
                String line = Utils.consoleReader();
                if (line!=null)
                    value = Integer.parseInt(line);
                else {
                    System.out.println("Значение числа должно быть не null. Попробуйте заново.");
                    continue;
                }
                if (Ycheck.check(value)) {
                    coordinates.setY(value);
                }
                else{
                    System.out.println("Значение числа должно быть <58. Попробуйте заново.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод. Попробуйте заново.");
                continue;
            }catch (ConsoleReadExceptions e){
                System.out.println(e.getMessage()+" Попробуйте заново.");
                continue;
            }
            break;
        }
        System.out.println("Обьект Coordinates успешно создан!");
        return coordinates;
    }
}
