package ru.yandex.qa.repository.one_to_many;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.yandex.qa.model.one_to_many.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select distinct c from Car c " +
            "left join fetch c.person p " +
             "left join fetch p.cars")
    List<Car> findAllFetchPerson();
}
