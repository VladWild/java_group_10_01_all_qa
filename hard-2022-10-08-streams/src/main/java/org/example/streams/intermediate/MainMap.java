package org.example.streams.intermediate;

import org.example.streams.entity.Car;
import org.example.streams.entity.Person;

import java.util.Arrays;
import java.util.List;

public class MainMap {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Игорь", new Car("ЛАДА Гранта")),
                new Person(2, "Катя", new Car("ЛАДА Приора")),
                new Person(3, "Alex", new Car("Audi A4")),
                new Person(4, "Саша", new Car("Мазда"))
        );

        List<Car> cars = people.stream()
                .map(Person::getCar)
                .toList();

        System.out.println(cars);

        int[] personIds = people.stream()
                .mapToInt(Person::getId)
                .toArray();

        System.out.println(Arrays.toString(personIds));

        Integer[] integers = people.stream()
                .map(Person::getId)
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(integers));
    }
}
