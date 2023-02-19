package ru.yandex.qa.one_to_many;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.JpaTest;
import ru.yandex.qa.model.one_to_many.Person;
import ru.yandex.qa.repository.one_to_many.PersonRepository;
import ru.yandex.qa.service.OneToManyService;

import java.util.List;

@Sql({"classpath:one_to_many/schema.sql", "classpath:one_to_many/data.sql"})
public class JpaOneToManyTest extends JpaTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private OneToManyService oneToManyService;

    /**
     * Связь OneToMany (показать, что тут дочерняя сущность лениво подгружается)
     */
    @Test
    void test() {
        List<Person> people = personRepository.findAll();
        System.out.println(people);
        System.out.println(people.size());
    }

    /**
     * Показ LazyInitializationException
     */
    @Test
    void test2() {
        List<Person> people = personRepository.findAll();

        Assertions.assertThrows(LazyInitializationException.class, () -> {
            for (Person person : people) {
                System.out.println(person.getCars());
            }
        });
    }

    /**
     * Но, это работает в транзакции!!!!
     * Однако получаем проблему N+1, что не очень хорошо
     */
    @Test
    void test3() {
        oneToManyService.printAllCars();
        System.out.println("Ok!");
    }

    //Далее показать, что есть EAGER и сказать, что им не стоит пользоваться (N + 1 тут тоже никуда не девается)!!!!

    /**
     * 1-ый способ решения пробремы N+1 - fetch-запрос
     * (про distinct тут сказать)
     */
    @Test
    void test4() {
        List<Person> people = personRepository.findFetchAll();
        people.forEach(p -> System.out.println("У " + p + " есть машины: " + p.getCars()));
    }

    /**
     * 2-ый способ решения пробремы N+1 - EntityGraph - обычный
     */
    @Test
    void test5() {
        List<Person> people = personRepository.findAllEntityGraph();
        people.forEach(p -> System.out.println("У " + p + " есть машины: " + p.getCars()));
    }

    /**
     * 2-ый способ решения пробремы N+1 - EntityGraph - именованный
     */
    @Test
    void test6() {
        List<Person> people = personRepository.findAllEntityGraphNamed();
        people.forEach(p -> System.out.println("У " + p + " есть машины: " + p.getCars()));
    }

    //Показать связь через
    /*
        @OneToMany
        @JoinColumn(name = "person_id")
     */
}
