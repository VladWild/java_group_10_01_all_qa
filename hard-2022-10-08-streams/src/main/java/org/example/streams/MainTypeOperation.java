package org.example.streams;

import org.example.streams.entity.Car;
import org.example.streams.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTypeOperation {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(2, "Катя", new Car("ЛАДА Приора")),
                new Person(3, "Alex", new Car("Audi A4")),
                new Person(4, "Саша", new Car("Мазда"))
        );

        System.out.println(people);

        List<Person> peopleFiltered = people.stream()
                .filter(person -> person.getId() > 2 && "Саша".equals(person.getName()))
                .toList();

        System.out.println(peopleFiltered);

        System.out.println("----------------------------");

        Stream<Person> personStream = people.stream()
                .filter(person -> {
                    //System.out.println(person);
                    return person.getId() > 2;
                });

        List<Person> people1 = personStream.toList();
        System.out.println(people1);

        //ошибка
        Set<Person> peopleSet = personStream.collect(Collectors.toSet());
    }
}
