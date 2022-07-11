package ru.yandex.qa.modify_.pac1;

public class Point {
    public int x;
    protected int y;
    int z;
    private String color;

    public int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }

    int getZ() {
        return z;
    }

    private String getColor() {
        return color;
    }

    public void method() {
        Point point = new Point();

        point.x = 1;
        point.y = 2;
        point.z = 3;
        point.color = "Красный";

        point.getX();
        point.getY();
        point.getZ();
        point.getColor();
    }
}
