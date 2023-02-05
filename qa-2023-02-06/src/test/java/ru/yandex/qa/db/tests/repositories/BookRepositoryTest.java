package ru.yandex.qa.db.tests.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.db.model.Book;
import ru.yandex.qa.db.repositories.BookRepository;
import ru.yandex.qa.db.tests.JpaH2Runner;

import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = BookRepository.class)
class BookRepositoryTest extends JpaH2Runner {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql("classpath:sql/book/add_book.sql")
    void findAllTest() {
        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }

    @Test
    @Sql("classpath:sql/book/add_book.sql")
    void findByIdTest() {
        Optional<Book> optionalBook = bookRepository.findById(1L);

        if (optionalBook.isPresent()) {
            System.out.println(optionalBook.get());
        }
    }

    @Test
    @Sql("classpath:sql/book/add_book.sql")
    void findByTitleTest() {
        List<Book> books = bookRepository.findByTitle("Метро 2034");
        System.out.println(books);
    }

    @Test
    @Sql("classpath:sql/book/add_book.sql")
    void findByTitleTest2() {
        List<Book> books = bookRepository.findByTitle2("Метро 2034");
        System.out.println(books);
    }

    @Test
    @Sql("classpath:sql/book/add_book.sql")
    void findByIdAndTitleTest() {
        Book book = bookRepository.findByIdAndTitle(1L, "Гарри Поттер");
        System.out.println(book);
    }

    @Test
    void saveTest() {
        Book book = new Book();
        book.setTitle("Моя книга");

        Book bookSave = bookRepository.saveAndFlush(book);

        List<Book> all = bookRepository.findAll();

        System.out.println(all);
    }

    @Test
    @Sql("classpath:sql/book/add_book.sql")
    void updateBookTest() {
        bookRepository.updateTitle(1L, "Гарри Поттер и Филосовский камень");

        Optional<Book> optionalBook = bookRepository.findById(1L);

        if (optionalBook.isPresent()) {
            System.out.println(optionalBook.get().getTitle());
        }

        //------------------------------
        //можно сделать это через save

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle("Гарри Поттер и Тайная комната");
            Book save = bookRepository.save(book);
            System.out.println(save.getTitle());
        }
    }

    @Test
    @Sql("classpath:sql/book/add_book.sql")
    void deleteBookTest() {
        bookRepository.deleteById(1L);

        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }

    @Test
    @Sql("classpath:sql/book/add_book.sql")
    void pageBook() {
        Page<Book> books = bookRepository.findAll(PageRequest.of(0, 2));
        System.out.println(books);
    }
}
