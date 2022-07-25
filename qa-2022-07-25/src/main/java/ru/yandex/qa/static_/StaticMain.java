package ru.yandex.qa.static_;

public class StaticMain {
    private static final String MAIN_NAME = "MAIN_NAME";

    public static void main(String[] args) {
        Point point = new Point("RED", -4, 5);
        Point point2 = new Point("BLUE", 4, 0);
        Point point3 = new Point("GREEN", -9, 1);
        Point point4 = new Point("BLUE", 4, 55);

        System.out.println(point);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println(point4);


        System.out.println("---------------------");

        Point white = new Point3D("WHITE", 0, 9);
        System.out.println(white.getColor());
        //white.method();

        Point.getColor();
        white.getX();

        Math.max(8, 9);

        Point white1 = PointFactory.getPoint("WHITE", 0, 9);

        StaticMain staticMain = new StaticMain();
        staticMain.method();
    }

    private void method() {
        main(new String[]{});
    }

    public static class PointFactory {

        public static Point getPoint(String color, int x, int y) {
            return new Point(color, x, y);
        }
    }

    public static class Point3D extends Point {
        public Point3D(String color, int x, int y) {
            super(color, x, y);
        }

        @Override
        public int getY() {
            return 4534534;
        }

        public void method() {

        }

        //@Override
        public static String getColor() {
            return Point.color;
        }
    }

    public static class Point {
        private static String color;
        private int x;
        private int y;

        public Point(String color, int x, int y) {
            Point.color = color;
            this.x = x;
            this.y = y;
        }

        public static String getColor() {
            return color;
        }

        public static void setColor(String color) {
            Point.color = color;
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

        @Override
        public String toString() {
            return "Point{" +
                    "color=" + color +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
