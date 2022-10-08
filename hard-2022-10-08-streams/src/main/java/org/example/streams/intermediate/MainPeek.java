package org.example.streams.intermediate;

import org.example.streams.entity.Car;
import org.example.streams.entity.Person;

import java.util.Arrays;
import java.util.List;

public class MainPeek {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(2, "Катя", new Car("ЛАДА Приора")),
                new Person(3, "Alex", new Car("Audi A4")),
                new Person(4, "Саша", new Car("Мазда"))
        );

        List<Person> peopleNullIds = people.stream()
                .peek(person -> person.setId(null))
                .toList();

        System.out.println(peopleNullIds);
    }
}
