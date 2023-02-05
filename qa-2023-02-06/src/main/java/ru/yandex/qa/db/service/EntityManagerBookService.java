/*
package ru.yandex.qa.db.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.qa.db.model.Book;

import javax.persistence.EntityManager;

@Service
public class EntityManagerBookService {

    private final EntityManager entityManager;

    public EntityManagerBookService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void persist(Book book) {
        entityManager.persist(book);
    }
}
*/
