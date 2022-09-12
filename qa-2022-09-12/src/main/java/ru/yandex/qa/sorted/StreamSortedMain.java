package ru.yandex.qa.sorted;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamSortedMain {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(2, "Катя", 24),
                new Person(4, "Саша", 21),
                new Person(3, "Игорь", 21)
        );

        System.out.println(people);

        List<Person> people1 = people.stream().sorted(Comparator.comparing(Person::getName)).toList();
        System.out.println("Сортировка по имени: " + people1);

        //одно и тоже
        //Collections.sort(people, (p1, p2) -> p1.name.compareTo(p2.name));
        //Collections.sort(people, Comparator.comparing(p -> p.name));
        //Collections.sort(people, Comparator.comparing(Person::getName));

        List<Person> people2 = people.stream().sorted(Comparator.comparingInt(Person::getAge).thenComparing(Person::getId)).toList();
        System.out.println("Сортировка по возрасту, если возрасты равны, то по id" + people2);
    }

    private static class Person {
        private Integer id;
        private String name;
        private int age;

        public Person(Integer id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
