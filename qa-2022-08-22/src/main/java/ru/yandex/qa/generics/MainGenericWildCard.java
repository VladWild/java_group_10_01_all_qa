package ru.yandex.qa.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 *                Object
 *                  |
 *                Animal
 *         Cat               Dog
 *          |
 *        Kitten
 */
public class MainGenericWildCard {

    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(new Animal("животное 1"), new Animal("животное 2"));
        List<Dog> dogs = Arrays.asList(new Dog("Rex"), new Dog("Тузик"));
        List<Cat> cats = Arrays.asList(new Cat("кот 1"), new Cat("Гарфилд"));
        List<Kitten> kittens = Arrays.asList(new Kitten("Мурзик"), new Kitten("Марсик"));

        print(animals);
        print(dogs);
        print(cats);
        print(kittens);

        //printCats(animals);
        //printCats(dogs);
        printCats(cats);
        printCats(kittens);

        printCatsUp(animals);
        //printCatsUp(dogs);
        printCatsUp(cats);
        //printCatsUp(kittens);

        Collections.copy(cats, kittens);
        System.out.println(cats);
    }

    private static void print(List<?> animals) {
        for (Object animal : animals) {
            System.out.println(animals.toString());
        }
    }

    private static void printCats(List<? extends Cat> animals) {
        for (Cat animal : animals) {
            System.out.println(animals.toString());
        }
    }

    private static void printCatsUp(List<? super Cat> animals) {
        for (Object animal : animals) {
            System.out.println(animals.toString());
        }
    }

    public static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + super.name + '\'' +
                    '}';
        }
    }

    public static class Kitten extends Cat {
        public Kitten(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Kitten{" +
                    //"name='" + super.name + '\'' +
                    '}';
        }
    }

    public static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + super.name + '\'' +
                    '}';
        }
    }
}
