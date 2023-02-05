package ru.yandex.qa.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.qa.db.model.Page;

public interface PageRepository extends JpaRepository<Page, String> {

}
