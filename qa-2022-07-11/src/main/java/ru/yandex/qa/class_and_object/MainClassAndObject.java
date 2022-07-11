package ru.yandex.qa.class_and_object;

public class MainClassAndObject {

    public static void main(String[] args) {
        Point point = new Point(2, 7, "Синий");
        System.out.println(point);
        Point point2 = new Point(-2, 3, "Красная");
        point2.setX(0);
        System.out.println(point2);

        Point point1 = new Point();
        point1.setX(4);
        point1.setY(8);
        point1.setColor("Желтая");
        System.out.println(point1);
    }

    public static class Point {
        private int x;
        private int y;
        private String color;

        public Point() {
        }

        public Point(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
