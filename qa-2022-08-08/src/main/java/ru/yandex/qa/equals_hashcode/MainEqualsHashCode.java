package ru.yandex.qa.equals_hashcode;

import java.util.Objects;

public class MainEqualsHashCode {

    public static void main(String[] args) {
        Point point = new Point(2, 10, Color.BLUE);
        Point point2 = new Point(10, 2, Color.BLUE);
        boolean equals = false;
        if (point2 != null) {
            equals = point2.equals(point);
        }
        System.out.println(equals);

        boolean equals1 = Objects.equals(point, point2);
        System.out.println(equals1);

        int hashCode = point.hashCode();
        int hashCode2 = point2.hashCode();
        System.out.println(hashCode);
        System.out.println(hashCode2);
    }

    private enum Color {
        RED, BLUE, GREEN;
    }

    private static class Point {
        private int x;
        private int y;
        private Color color;

        public Point(int x, int y, Color color) {
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

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && color == point.color;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, color);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", color=" + color +
                    '}';
        }
    }
}
