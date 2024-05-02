package model.comparators;

import model.SpaceMarine;

import java.util.Comparator;

public class MarineIdComparator implements Comparator<SpaceMarine>{
    @Override
    public int compare(SpaceMarine o1, SpaceMarine o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
