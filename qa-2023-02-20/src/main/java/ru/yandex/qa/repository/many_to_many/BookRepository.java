package ru.yandex.qa.repository.many_to_many;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.yandex.qa.model.many_to_many.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    @EntityGraph(attributePaths = "authors")
    @Query("select b from Book b where b.id = ?1")
    Book findByIdEntityGraph(Long id);
}
