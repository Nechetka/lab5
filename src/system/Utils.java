package system;

public class SomeMethods {
    static public String isEmptyLineValue(String line){
        if (line.trim().isEmpty()){
            return null;
        }
        else {
            return line;
        }
    }
}
