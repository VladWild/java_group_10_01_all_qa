package ru.yandex.qa.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapStarter2 {

    public static void main(String[] args) {
        Map<Integer, Person> map = new TreeMap<>();

        map.put(1, new Person("Игорь", 24));
        map.put(546456, new Person("Игорь", 24));
        map.put(-646456, new Person("Игорь", 24));
        map.put(Integer.MAX_VALUE, new Person("Игорь", 24));
        map.put(Integer.MIN_VALUE, new Person("Игорь", 24));
        map.put(0, new Person("Игорь", 24));
        map.put(456, new Person("Игорь", 24));

        System.out.println(map);
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
