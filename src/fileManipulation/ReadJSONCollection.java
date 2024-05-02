package fileManipulation;

import model.SpaceMarine;

import java.io.IOException;
import java.util.TreeSet;

public class deserializationJSONCollection implements DeserializationObject<TreeSet<SpaceMarine>>{
    @Override
    public TreeSet<SpaceMarine> read(String path) throws IOException {
        TreeSet<SpaceMarine> spaceList = new TreeSet<>();

        return spaceList;
    }
}
