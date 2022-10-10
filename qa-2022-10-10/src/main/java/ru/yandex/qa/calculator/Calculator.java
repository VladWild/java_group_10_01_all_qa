package ru.yandex.qa.calculator;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int diff(int a, int b) {
        return a - b;
    }

    public int abc(int a) {
        return a > 0 ? a : -a;
    }

    public int division(int a, int b) {
        if (b == 0) {
            throw new UnsupportedOperationException();
        }
        return a / b;
    }
}
