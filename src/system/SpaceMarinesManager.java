package system;

import model.SpaceMarine;
import model.comparators.MarineHealthComparator;

import java.time.Instant;
import java.util.*;

public class SpaceMarinesManager implements CollectionReceiver<TreeSet<SpaceMarine>, SpaceMarine> {
    static private SpaceMarinesManager collection;
    public static  SpaceMarinesManager getInstance(){
        if (collection == null){
            collection = new SpaceMarinesManager();
        }
        return collection;
    }
    private TreeSet<SpaceMarine> marines;
    private final Date initDate;

    private SpaceMarinesManager() {
        marines = new TreeSet<>();
        initDate = Date.from(Instant.now());
    }

    @Override
    public TreeSet<SpaceMarine> getCollection() {
        return marines;
    }

    @Override
    public void setCollection(TreeSet<SpaceMarine> value) {
        this.marines = value;
    }

    @Override
    public void addElementToCollection(SpaceMarine value) {
        this.marines.add(value);
    }

    @Override
    public void clearCollection() {
        this.marines.clear();
    }

    @Override
    public void sort() {
        TreeSet<SpaceMarine> sortedMarines = new TreeSet<>();

        for (Iterator<SpaceMarine> obj = marines.stream().sorted(new MarineHealthComparator()).iterator(); obj.hasNext(); ) {
            SpaceMarine sortedItem = obj.next();

            sortedMarines.add(sortedItem);
        }

        this.marines = sortedMarines;
    }


    @Override
    public Date getInitDate() {
        return initDate;
    }

    public int getSize(){
        return marines.size();
    }
    public  SpaceMarine getMinElement(Comparator<SpaceMarine> comparator){
        return getCollection().stream().min(comparator).orElse(null);
    }
    public SpaceMarine getMaxElement(Comparator<SpaceMarine> comparator){
        return getCollection().stream().max(comparator).orElse(null);
    }
}
