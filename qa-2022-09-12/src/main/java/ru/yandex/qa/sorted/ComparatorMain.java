package ru.yandex.qa.sorted;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorMain {

    public static void main(String[] args) {
        Set<Person> people = new TreeSet<>(new PersonAgeComparator());

        Person person = new Person(1, "Коля", 34);
        Person person2 = new Person(2, "Катя", 24);
        Person person3 = new Person(3, "Саша", 21);
        Person person4 = new Person(4, "Игорь", 21);
        Person person5 = new Person(5, "Оля", 32);

        people.add(person);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

        System.out.println(people);

        System.out.println("---------------------");

        //------------------

        Set<Person> people2 = new TreeSet<>(new PersonNameComparator());

        people2.add(person);
        people2.add(person2);
        people2.add(person3);
        people2.add(person4);
        people2.add(person5);

        System.out.println(people2);
    }

    private static class PersonNameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            int result = o1.name.compareTo(o2.name);
            if (result == 0) {
                return o1.id - o2.id;
            }
            return result;
        }
    }

    private static class PersonAgeComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            int result = o1.age - o2.age;
            if (result == 0) {
                return o1.id - o2.id;
            }
            return result;
        }
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
