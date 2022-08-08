package ru.yandex.qa.interface_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainInterface {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        doSomething(list);

        List<Object> list1 = new LinkedList<>();
        doSomething(list1);
    }

    private static void doSomething(List<Object> list) {
        //do something
    }
}
