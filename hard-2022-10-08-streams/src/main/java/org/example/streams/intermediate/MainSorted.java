package org.example.streams.intermediate;

import org.example.streams.entity.Car;
import org.example.streams.entity.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainSorted {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(3, "Игорь", new Car("ЛАДА Гранта")),
                new Person(4, "Катя", new Car("ЛАДА Приора")),
                new Person(1, "Alex", new Car("Audi A4")),
                new Person(2, "Саша", new Car("Мазда"))
        );

        System.out.println(people);

        List<Person> peopleSorted = people.stream()
                .sorted((p1, p2) -> p1.getId() - p2.getId())
                .toList();

        System.out.println(peopleSorted);

        List<Person> peopleSorted2 = people.stream()
                .sorted((p1, p2) -> p2.getId() - p1.getId())
                .toList();

        System.out.println(peopleSorted2);

        List<Person> peopleSortedShort = people.stream()
                .sorted(Comparator.comparingInt(Person::getId))
                .toList();

        System.out.println(peopleSortedShort);

        List<Person> peopleSortedShort2 = people.stream()
                .sorted(Comparator.comparingInt(Person::getId).reversed())
                .toList();

        System.out.println(peopleSortedShort2);
    }
}
