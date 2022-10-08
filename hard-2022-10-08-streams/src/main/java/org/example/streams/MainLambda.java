package org.example.streams;

import java.util.function.Function;

public class MainLambda {

    public static void main(String[] args) {
        MainLambda mainLambda = new MainLambda();
        mainLambda.run();
    }

    public void run() {
        //1)
        MyFunction myFunction = new MyFunction();
        print(myFunction, "Text!!");

        //2)
        Function<String, Integer> function2 = new Function<>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        print(function2, "Text!!");

        //3)
        Function<String, Integer> function3 = o -> {
            //some logic
            return o.length();
        };
        print(function3, "Text!!");

        //4)
        Function<String, Integer> function4 = o -> o.length();
        print(function4, "Text!!");

        //5)
        Function<String, Integer> function5 = String::length;
        print(function5, "Text!!");
    }

    public <T, R> void print(Function<T, R> function, T text) {
        R result = function.apply(text);
        System.out.println(text + " -> длинна строки: " + result);
    }

    class MyFunction implements Function<String, Integer> {

        @Override
        public Integer apply(String s) {
            return s.length();
        }
    }
}