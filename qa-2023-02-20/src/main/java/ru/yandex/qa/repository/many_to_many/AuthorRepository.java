package ru.yandex.qa.repository.many_to_many;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.qa.model.many_to_many.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
