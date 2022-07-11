package ru.yandex.qa.tz1;

import java.util.Scanner;

public class MainSwitch {

    public static void main(String[] args) {
        //число
        //exampleInt();

        //строка
        //exampleString();

        //enum
        exampleEnum();
    }

    private static void exampleEnum() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цвет");
        String colorStr = scanner.next();
        Color color = getColor(colorStr);

        switch (color) {
            case BLUE -> System.out.println("Вы ввели синий цвет");
            case RED, GREEN -> System.out.println("Вы ввели красный или зеленый цвет");
            default -> System.out.println("Неизвестный цвет");
        }

        scanner.close();
    }

    public enum Color {
        BLUE("синий"), RED("красный"), GREEN(""), UNKNOW("");

        private String rus;

        Color(String rus) {
            this.rus = rus;
        }
    }

    private static Color getColor(String colorStr) {
        Color color = null;
        try {
            color = Color.valueOf(colorStr);
        } catch (IllegalArgumentException ex) {
            color = Color.UNKNOW;
        }
        return color;
    }

    private static void exampleString() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число строкой:");
        String str = scanner.next();

        switch (str) {
            case "1": {
                System.out.println("Вы ввели 1");
                break;
            }
            case "2", "3":
                System.out.println("Вы ввели 2 или 3");
                break;
            default:
                System.out.println("Что-то неизвестное");
        }

        scanner.close();
    }

    private static void exampleInt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                System.out.println("Вы ввели число 1");
                break;
            case 2:
                System.out.println("Вы ввели число 2");
                break;
            default:
                System.out.println("Вы ввели неизвестное число");
        }

        scanner.close();
    }
}
