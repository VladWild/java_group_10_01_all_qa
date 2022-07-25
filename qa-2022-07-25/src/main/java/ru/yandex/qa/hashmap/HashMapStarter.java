package ru.yandex.qa.hashmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapStarter {

    public static void main(String[] args) {
        Map<String, Person> map = new HashMap<>();
        map.put("Игорь", new Person("Игорь", 34));
        map.put("Катя", new Person("Екатерина", 21));
        System.out.println(map);

        Person person = map.get("Игорь");
        System.out.println(person);

        map.put("Игорь", new Person("Игорь 2", 28));

        Person person2 = map.get("Игорь");
        System.out.println(person2);

        System.out.println("------------------");

        Set<String> strings = map.keySet();
        System.out.println(strings);

        Collection<Person> values = map.values();
        System.out.println(values);

        Set<Map.Entry<String, Person>> entries = map.entrySet();
        for (Map.Entry<String, Person> entry : entries) {
            String key = entry.getKey();
            Person value = entry.getValue();
            System.out.println("Ключ = " + key + " значение = " + value);
        }
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
