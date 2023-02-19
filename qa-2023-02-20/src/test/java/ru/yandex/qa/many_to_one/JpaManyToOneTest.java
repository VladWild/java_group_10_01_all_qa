package ru.yandex.qa.many_to_one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.JpaTest;
import ru.yandex.qa.model.one_to_many.Car;
import ru.yandex.qa.repository.one_to_many.CarRepository;

import java.util.List;

@Sql({"classpath:one_to_many/schema.sql", "classpath:one_to_many/data.sql"})
public class JpaManyToOneTest extends JpaTest {

    @Autowired
    private CarRepository carRepository;

    /**
     * Связь ManyToOne (показать, что тут родительская сущность сразу подгружается)
     */
    @Test
    void test() {
        List<Car> cars = carRepository.findAll();
        cars.forEach(c -> System.out.println("У машины " + c + " владелец " + c.getPerson()));
        System.out.println("Всего машин: " + cars.size());
    }

    //Показать как это через LAZY работает и что EAGER на LAZY менять не так опасно, как наоборот

    /**
     * feach-запрос со всеми машинами у person
     * (про distinct тоже сказать)
     */
    @Test
    void test2() {
        List<Car> cars = carRepository.findAllFetchPerson();
        cars.forEach(c -> System.out.println("У машины " + c + " владелец " + c.getPerson() +
                " у которого есть " + c.getPerson().getCars().size() + " машины"));
    }
}
