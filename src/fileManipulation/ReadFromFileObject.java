package fileManipulation;

import java.io.IOException;

public interface ReadFromFileObject<T> {
    public T read (String path);
}
