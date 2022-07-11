package ru.yandex.qa.modify_.pac2;

import ru.yandex.qa.modify_.pac1.Point;

public class PointExtend extends Point {

    public void method() {
        PointExtend point = new PointExtend();

        point.x = 1;
        point.y = 2;
        //point.z = 3;
        //point.color = "Красный";

        point.getX();
        point.getY();
        //point.getZ();
        //point.getColor();
    }
}
