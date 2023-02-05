package ru.yandex.qa.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.qa.db.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    @Query("select b from Book b where b.title = ?1")
    List<Book> findByTitle2(String s);

    //@Query("select b from Book b where b.id = ?1 and b.title = ?2")
    Book findByIdAndTitle(Long id, String title);

    @Transactional
    @Modifying
    @Query("update Book b " +
            "set b.title = :title " +
            "where b.id = :id")
    void updateTitle(@Param("id") Long id, @Param("title") String title);
}
