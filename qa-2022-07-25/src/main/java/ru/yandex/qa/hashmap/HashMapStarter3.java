package ru.yandex.qa.hashmap;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapStarter3 {

    public static void main(String[] args) {
        Map<Person, String> personStringHashMap = new HashMap<>();

        Person person = new Person("Игорь", 34, LocalDate.now());
        personStringHashMap.put(person, "Игорь");
        personStringHashMap.put(new Person("Екатерина", 34, LocalDate.now()), "Катя");
        LocalDate localDate = person.getLocalDate();
        localDate = LocalDate.now().minusDays(4);

        System.out.println(personStringHashMap);

        personStringHashMap.put(new Person("Игорь", 34, LocalDate.now()), "Игорь 2");

        System.out.println(personStringHashMap);

        System.out.println(personStringHashMap.get(person));
    }

    public final static class Person {
        private final String name;
        private final int age;
        private final LocalDate localDate;

        public Person(String name, int age, LocalDate localDate) {
            this.name = name;
            this.age = age;
            this.localDate = localDate;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public LocalDate getLocalDate() {
            int year = localDate.getYear();
            Month month = localDate.getMonth();
            int dayOfMonth = localDate.getDayOfMonth();
            return LocalDate.of(year, month, dayOfMonth);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name)
                    && Objects.equals(localDate, person.localDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, localDate);
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
