package ru.yandex.qa.tz1;

import java.util.Scanner;

public class MainSwitch {

    public static void main(String[] args) {
        //число
        //exampleInt();

        //строка
        //exampleString();

        //Енам
        //exampleEnum();
    }

    private static void exampleEnum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цвет:");
        String colorStr = scanner.nextLine();
        Color color = getColor(colorStr);

        switch (color) {
            case RED -> System.out.println("Вы ввели красный цвет");
            case BLUE, GREEN -> System.out.println("Вы ввели синий или зеленый цвет");
            default -> System.out.println("Неизвестный цвет");
        }

        scanner.close();
    }

    private static Color getColor(String colorStr) {
        Color color = null;
        try {
            color = Color.valueOf(colorStr);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка распознавания цвета");
            color = Color.UNKNOWN;
        }
        return color;
    }

    private static enum Color {
        BLUE, RED, GREEN, UNKNOWN;
    }

    private static void exampleString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str = scanner.nextLine();

        switch (str) {
            case "1":
                System.out.println("Вы ввели строкой число 1");
                break;
            case "2", "3":
                System.out.println("Вы ввели строкой число 2 или 3");
                break;
            default:
                System.out.println("Вы ввели что-то не понятное");
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
            case 3:
                System.out.println("Вы ввели число 3");
                break;
            case 4:
                System.out.println("Вы ввели число 4");
                break;
            default:
                System.out.println("Вы ввели неизвестное число");
        }

        scanner.close();
    }
}
