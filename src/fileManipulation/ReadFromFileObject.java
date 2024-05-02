package fileManipulation;

import java.io.IOException;

public interface DeserializationObject<T> {
    public T read (String path) throws IOException;
}
