package ru.yandex.qa.generics;

import java.util.ArrayList;

/*
 * В чем проблема?
 * Java не знает об типе, хранящемся в коллекции -> без дженериков надо делать постоянно Cast
 *
 * Без дженериков может быть java.lang.ClassCastException
 * Дженерики защищают нас от этого исключения -> программа даже не скомпилируется
 */
public class MainGenericsProblemsResolve {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Вася"));
        people.add(new Person("Игоря"));
        people.add(new Person("Катя"));

        Person o = people.get(0);
        System.out.println(o.getName());

        System.out.println("---------------------");

        ArrayList<String> list = new ArrayList<>();
        //list.add(new Person("Игорь"));
        list.add("Игорь");
        //list.add(45456L);
        //list.add(new Object());

        //Person o1 = (Person) list.get(0);
        //Long o2 = (Long) list.get(2);
    }

    public static abstract class Entity<T> {
        private T id;

        public T getId() {
            return id;
        }

        public void setId(T id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "id=" + id +
                    '}';
        }
    }

    public static class Person extends Entity<Long> {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
