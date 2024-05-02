package fileManipulation;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SerializationObject <T>{
    public void write (String path, T obj) throws IOException;
}
