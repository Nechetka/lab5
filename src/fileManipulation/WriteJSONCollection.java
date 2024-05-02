package fileManipulation;

import com.google.gson.Gson;
import java.io.*;

public class serializationJSONCollection<T> implements SerializationObject<T>{

    @Override
    public void write(String path,T obj) throws IOException  {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        FileOutputStream out = new FileOutputStream(path + "/SpaceMarines.json");
        Writer writer = new OutputStreamWriter(out);
        writer.write(json);
        writer.close();
    }
}
