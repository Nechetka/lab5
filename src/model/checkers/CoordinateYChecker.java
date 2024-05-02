package model.checkers;

public class YCoordinateChecker implements Checked<Integer>{
    @Override
    public boolean check(Integer obj) {
        return (obj != null && obj <= 58);
    }
}
