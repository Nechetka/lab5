package system;

import exceptions.WrongValuesOfCommandArgumentException;
import model.SpaceMarine;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class Utils {
    static public String isEmptyLine(String line) {
        if (line.isEmpty()) {
            return null;
        } else {
            return line;
        }
    }
    private static String enviromentPath;

    private static Long id = 0L;
    static public Long getNewId() {
        TreeSet<SpaceMarine> coll = SpaceMarinesManager.getInstance().getCollection();
        LinkedHashSet<Long> ids = new LinkedHashSet<>();
        coll.forEach(obj -> ids.add(obj.getId()));
        Random dice = new Random();
        id = dice.nextLong(1,Long.MAX_VALUE);
        while (ids.contains(id) | id == 0L) {
            id = dice.nextLong(1,Long.MAX_VALUE);
        }
        return id;
    }

    public static void checkArgumentsOrThrow(int given, int needed) throws WrongValuesOfCommandArgumentException {
        if (given - 1 != needed)
            throw new WrongValuesOfCommandArgumentException("Вы ввели " + (given - 1) + " аргументов комманды, а надо " + needed);
    }

    public static String getEnv() {
        return enviromentPath;
    }

    public static void setEnv(String enviromentPath) {
        Utils.enviromentPath = enviromentPath;
    }
}

