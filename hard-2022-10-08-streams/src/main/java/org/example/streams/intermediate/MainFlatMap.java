package org.example.streams.intermediate;

import org.example.streams.entity.Car;
import org.example.streams.entity.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainFlatMap {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(2, "Катя", new Car("ЛАДА Приора"))
        );

        List<Person> people2 = Arrays.asList(
                new Person(3, "Alex", new Car("Audi A4")),
                new Person(4, "Саша", new Car("Мазда"))
        );

        List<List<Person>> lists = Arrays.asList(
                people,
                people2
        );

        List<Person> people1 = lists.stream()
                .flatMap(peopleList -> peopleList.stream())
                .toList();

        System.out.println(people1);

        List<Person> people4 = lists.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println(people4);
    }
}
