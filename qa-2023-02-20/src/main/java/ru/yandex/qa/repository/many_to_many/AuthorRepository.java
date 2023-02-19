package ru.yandex.qa.repository.many_to_many;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.yandex.qa.model.many_to_many.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a " +
            "left join fetch a.books")
    List<Author> findAllFetch();
}
