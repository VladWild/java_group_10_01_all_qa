package org.example.streams.terminal;

import org.example.streams.entity.Car;
import org.example.streams.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainCollect {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(2, "Катя", new Car("ЛАДА Приора")),
                new Person(3, "Alex", new Car("Audi A4")),
                new Person(4, "Саша", new Car("Мазда"))
        );

        List<Person> peopleList = people.stream().collect(Collectors.toList());
        List<Person> peopleList2 = people.stream().toList();
        Set<Person> peopleSet = people.stream().collect(Collectors.toSet());

        //map

        Map<Integer, Person> peopleMap = people.stream()
                .collect(Collectors.toMap(Person::getId, person -> person));
        System.out.println(peopleMap);

        Map<Integer, Person> peopleMap2 = people.stream()
                .collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(peopleMap2);

        //приколы с map'ой

        List<Person> people2 = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(1, "Катя", new Car("ЛАДА Приора")),
                new Person(2, "Alex", new Car("Audi A4")),
                new Person(2, "Саша", new Car("Мазда"))
        );

        Map<Integer, Person> peopleMap3 = people2.stream()
                .collect(Collectors.toMap(Person::getId, Function.identity(), (p1, p2) -> p1));
        System.out.println(peopleMap3);

        Map<Integer, List<Person>> peopleMapGroup = people2.stream()
                .collect(Collectors.groupingBy(Person::getId));
        System.out.println(peopleMapGroup);
    }
}
