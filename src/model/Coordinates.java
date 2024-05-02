package model;

public class Coordinates {
    private Double x; //Поле не может быть null
    private int y; //Максимальное значение поля: 58

    public void setX(Double x) {
        this.x = x;
    }

    public Double getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
}
