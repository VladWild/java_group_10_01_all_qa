package ru.yandex.qa.exceptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainExceptions {

    public static void main(String[] args) {
        try {
            method();
        } catch (MyExceptoin myExceptoin) {
            System.out.println(myExceptoin);
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }

        Object o = new Object();
        o.toString();

        //new FileOutputStream("dscdscd");

        try {
            Files.readString(Path.of("путь до файла"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void method() {
        throw new MyExceptoin();
    }

    public static class MyExceptoin extends RuntimeException {

    }
}
