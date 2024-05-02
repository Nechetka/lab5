package system;


import java.util.AbstractCollection;
import java.util.Date;

public interface CollectionManager<T extends AbstractCollection<E>, E> {
    T getCollection();
    void setCollection(T value);
    void addElementToCollection(E value);
    void clearCollection();
    void sort();
    E getFirstOrNew();
    Date getInitDate();
}