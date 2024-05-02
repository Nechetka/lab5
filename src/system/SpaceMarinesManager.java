package system;

import model.SpaceMarine;

import java.time.Instant;
import java.util.Date;
import java.util.TreeSet;

public class CollectionManager {
    static private CollectionManager collection;
    private static CollectionManager getInstance(){
        if (collection==null){
            collection = new CollectionManager();
        }
        return collection;
    }
    private TreeSet<SpaceMarine> marines;
    private final Date initDate;

    private CollectionManager() {
        marines = new TreeSet<>();
        initDate = Date.from(Instant.now());
    }


}
