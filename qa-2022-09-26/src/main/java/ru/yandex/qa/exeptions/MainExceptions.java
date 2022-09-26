package ru.yandex.qa.exeptions;

public class MainExceptions {

    public static void main(String[] args) throws MyException {
        /*try {
            throw new MyException();
        } catch (MyException e) {
            //throw new RuntimeException(e);
            //обработка
        }*/

        //throw new RuntimeException();

        Integer i = null;
        i.intValue();
    }

    public static class MyException extends Exception {

    }

    public static class MeRuntimeException extends RuntimeException {

    }
}
