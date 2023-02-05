package ru.yandex.qa.db.tests.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.db.model.Author;
import ru.yandex.qa.db.model.Book;
import ru.yandex.qa.db.model.BookAuthor;
import ru.yandex.qa.db.repositories.AuthorRepository;
import ru.yandex.qa.db.repositories.BookAuthorRepository;
import ru.yandex.qa.db.repositories.BookRepository;
import ru.yandex.qa.db.tests.JpaH2Runner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@ContextConfiguration(classes = {
        BookRepository.class,
        AuthorRepository.class,
        //AuthorBookService.class,
        BookAuthorRepository.class
})
public class AuthorRepositoryTest extends JpaH2Runner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    /*@Autowired
    private AuthorBookService authorBookService;*/

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Test
    @Sql(value = {
            "classpath:sql/author/add_author.sql",
            "classpath:sql/book/add_book.sql",
            "classpath:sql/book_author/link_author_book.sql",
    })
    void findAllBooksTest() {
        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }

    @Test
    void saveBooksWithAuthorsTest() {
        Book book = new Book();
        book.setTitle("Книга 1");

        Book book2 = new Book();
        book2.setTitle("Книга 2");

        Author author = new Author();
        author.setName("Автор 1");

        Author author2 = new Author();
        author2.setName("Автор 2");

        //надо сохранить авторов
        authorRepository.saveAllAndFlush(Arrays.asList(author, author2));

        book.setAuthors(Set.of(author, author2));
        book2.setAuthors(Set.of(author));

        List<Book> books = bookRepository.saveAllAndFlush(Arrays.asList(book, book2));

        System.out.println(books);
    }

    @Test
    void saveBooksWithAuthorsTest2() {
        Book book = new Book();
        book.setTitle("Книга 1");

        Book book2 = new Book();
        book2.setTitle("Книга 2");

        Author author = new Author();
        author.setName("Автор 1");

        Author author2 = new Author();
        author2.setName("Автор 2");

        book.setAuthors(Set.of(author, author2));
        book2.setAuthors(Set.of(author));

        /*authorBookService.saveAuthorWithBook(
                Arrays.asList(author, author2),
                Arrays.asList(book, book2)
        );*/

        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }

    @Test
    @Sql({
            "classpath:sql/author/add_author.sql",
            "classpath:sql/book/add_book.sql"
    })
    void bookAuthorRepositoryTest() {
        /*List<Book> books = bookRepository.findAll();
        List<Author> authors = authorRepository.findAll();

        System.out.println(books);
        System.out.println(authors);*/

        bookAuthorRepository.saveAllAndFlush(Arrays.asList(
                new BookAuthor(5L, 10L),
                new BookAuthor(1L, 20L)
        ));

        List<Book> books2 = bookRepository.findAll();
        List<Author> authors2 = authorRepository.findAll();

        System.out.println(books2);
        System.out.println(authors2);
    }
}
