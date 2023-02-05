package ru.yandex.qa.db.tests.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.db.model.Book;
import ru.yandex.qa.db.model.Page;
import ru.yandex.qa.db.repositories.BookRepository;
import ru.yandex.qa.db.repositories.PageRepository;
import ru.yandex.qa.db.tests.JpaH2Runner;

import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = {BookRepository.class, PageRepository.class})
public class BookPageRepositoryTest extends JpaH2Runner {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void saveTest() {
        Page page = new Page();
        page.setText("Какой-то текст");

        Page pageSave = pageRepository.saveAndFlush(page);

        System.out.println(pageSave);
    }

    @Test
    @Sql("classpath:sql/book/add_book.sql")
    void savePageWithBookTest() {
        Page page = new Page();
        page.setText("Какой-то текст");

        Optional<Book> optionalBook = bookRepository.findById(1L);
        page.setBook(optionalBook.get());

        Page pageSave = pageRepository.saveAndFlush(page);

        System.out.println(pageSave);
    }

    @Test
    @Sql({"classpath:sql/book/add_book.sql", "classpath:sql/page/add_page.sql"})
    void findBooksAndPages() {
        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }
}
