package model.Creators.NonUSerCreators;

import exceptions.CreateObjectException;
import model.Coordinates;
import model.Creators.BaseObjectUserCreator;
import model.checkers.Checked;
import model.checkers.CoordinateYChecker;
import system.UserConsole;

import java.util.Scanner;

public class CoordinatesNonUserCreator implements BaseObjectUserCreator<Coordinates> {
    private final Scanner out;

    public CoordinatesNonUserCreator(Scanner scanner) {
        out = scanner;
    }

    @Override
    public Coordinates create() throws CreateObjectException {
        Coordinates coordinates = new Coordinates();
        UserConsole console = new UserConsole(out);
        try {
            String line = console.read();
            double x = Double.parseDouble(line);
            coordinates.setX(x);
            Checked<Integer> Ycheck = new CoordinateYChecker();
            line = console.read();
            int y = Integer.parseInt(line);
            if (Ycheck.check(y)) {
                coordinates.setY(y);
            } else {
                throw new CreateObjectException("Значение числа должно быть <58.");
            }
        } catch (Exception e) {
            throw new CreateObjectException(e.getMessage());
        }
        return coordinates;
    }
}