package ru.yandex.qa.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.qa.db.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
