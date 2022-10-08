package org.example.streams.terminal;

import org.example.streams.entity.Car;
import org.example.streams.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class MainFindFirstFindAnyFindMax {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(2, "Катя", new Car("ЛАДА Приора")),
                new Person(3, "Alex", new Car("Audi A4")),
                new Person(4, "Саша", new Car("Мазда"))
        );

        Optional<Person> first = people.stream().findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        }

        Person person = people.stream().findFirst().orElse(null);
        System.out.println(person);

        Person personAny = people.stream()
                .filter(person1 -> person1.getId() > 2)
                .findAny()
                .orElse(null);
        System.out.println(personAny);

        OptionalInt max = people.stream().mapToInt(Person::getId).max();
        int asInt = max.getAsInt();
        System.out.println(asInt);

        Person person1 = people.stream().max((p1, p2) -> p1.getId() - p2.getId()).get();
        System.out.println(person1);
    }
}
