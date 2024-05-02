package model.checkers;

public interface Checked<T> {
    public boolean check(T obj);
}
