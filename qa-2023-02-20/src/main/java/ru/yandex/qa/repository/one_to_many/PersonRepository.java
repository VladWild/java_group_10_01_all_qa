package ru.yandex.qa.repository.one_to_many;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.yandex.qa.model.one_to_many.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select distinct p from Person p " +
            "left join fetch p.cars")
    List<Person> findFetchAll();

    @EntityGraph(attributePaths = "cars")
    @Query("select p from Person p")
    List<Person> findAllEntityGraph();

    @EntityGraph("Person.cars")
    @Query("select p from Person p")
    List<Person> findAllEntityGraphNamed();
}
