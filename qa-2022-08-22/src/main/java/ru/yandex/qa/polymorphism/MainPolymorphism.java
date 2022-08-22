package ru.yandex.qa.polymorphism;

public class MainPolymorphism {

    public static void main(String[] args) {
        Cat kitten = new Kitten();
        kitten.eat();

        Object o = new Cat();
        System.out.println(o.toString());
    }

    public static class Cat {
        private String name = "Мурзик!";

        public void eat() {
            System.out.println("Я кот и хочу есть!!!!");
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Kitten extends Cat {

        @Override
        public void eat() {
            System.out.println("Котенок хочет есть");
        }
    }
}
