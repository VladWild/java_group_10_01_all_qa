package ru.yandex.qa.db.tests.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import ru.yandex.qa.db.model.Book;
import ru.yandex.qa.db.repositories.BookRepository;
import ru.yandex.qa.db.tests.JpaH2Runner;

import javax.persistence.EntityManager;

@ContextConfiguration(classes = BookRepository.class)
public class EntityManagerBookTest extends JpaH2Runner {

    @Autowired
    private EntityManager entityManager;

    @Test
    void entityManagerPersistTest() {
        Book book = new Book();
        book.setTitle("Книга 1");

        entityManager.persist(book);

        Book book1 = entityManager.find(Book.class, 1L);
        System.out.println(book1);
    }

    /*@Test
    void entityManagerPersistTransactionTest() {
        Book book = new Book();
        book.setTitle("Книга 1");

        self.persist(book);

        Book book1 = entityManager.find(Book.class, 1L);
        System.out.println(book1);
    }*/

    @Test
    void entityManagerPersistTest2() {
        Book book = new Book();
        book.setTitle("Книга 1");

        entityManager.persist(book);
        entityManager.flush();

        Book book1 = entityManager.find(Book.class, 1L);
        System.out.println(book1);
    }

    @Test
    void entityManagerRemoveTest2() {
        Book book = new Book();
        book.setTitle("Моя книга");

        entityManager.persist(book);
        entityManager.flush();
        entityManager.remove(book);
        entityManager.flush();

        Book book1 = entityManager.find(Book.class, 1L);
        System.out.println(book1);
    }
}
