package ru.yandex.qa.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.qa.db.model.BookAuthor;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthor> {

}
