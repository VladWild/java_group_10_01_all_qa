package ru.yandex.qa.many_to_many;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;
import ru.yandex.qa.JpaTest;
import ru.yandex.qa.many_to_many.utils.JpaManyToManyTestUtils;
import ru.yandex.qa.model.many_to_many.Author;
import ru.yandex.qa.model.many_to_many.Book;
import ru.yandex.qa.model.many_to_many.BookAuthor;
import ru.yandex.qa.repository.many_to_many.AuthorRepository;
import ru.yandex.qa.repository.many_to_many.BookAuthorRepository;
import ru.yandex.qa.repository.many_to_many.BookRepository;
import ru.yandex.qa.service.ManyToManyService;

import java.util.List;

@Sql({"classpath:many_to_many/schema.sql", "classpath:many_to_many/data.sql"})
public class JpaManyToManyTest extends JpaTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    private ManyToManyService manyToManyService;

    /**
     * Связь ManyToMany (со стороны книг ленивая подгрузка авторов)
     */
    @Test
    void test() {
        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }

    /**
     * Связь ManyToMany (достаем EntityGraph'ом авторов)
     */
    @Test
    void test2() {
        List<Book> books = bookRepository.findAllEntityGraph();
        books.forEach(b -> System.out.println("У книги " + b + " авторы: " + b.getAuthors()));
    }

    /**
     * Связь ManyToMany (со стороны авторов ленивая подгрузка книг)
     */
    @Test
    void test3() {
        List<Author> authors = authorRepository.findAll();
        System.out.println(authors);
    }

    /**
     * Связь ManyToMany (достаем fetch-запросом книги)
     */
    @Test
    void test4() {
        List<Author> authors = authorRepository.findAllFetch();
        authors.forEach(a -> System.out.println("У автора " + a + " книги: " + a.getBooks()));
    }

    /**
     * Показать, что может быть исключение и все это делается в разных транзакциях
     */
    @Test
    void test5() {
        Author author = JpaManyToManyTestUtils.createAuthor("Новый автор");
        Author authorSave = authorRepository.save(author);

        Long bookId = bookRepository.findIdByName("Гарри Поттер и Филасовский Камень");

        BookAuthor bookAuthor = new BookAuthor(bookId, authorSave.getId());
        bookAuthorRepository.save(bookAuthor);

        Book bookWithNewAuthor = bookRepository.findByIdEntityGraph(bookId);
        System.out.println(bookWithNewAuthor);
    }

    @Test
    void test6() {
        Long bookId = manyToManyService.saveNewAuthorAndAddToBook("Новый автор");
        System.out.println("Ок!!!!");

        Book bookWithNewAuthor = bookRepository.findByIdEntityGraph(bookId);
        System.out.println(bookWithNewAuthor);
    }

    @Test
    void test7() {
        manyToManyService.method("Новый автор");
        System.out.println("Ок!!!!");
    }

    @Test
    void test8() {
        manyToManyService.method2();
        System.out.println("Ok!!!!");
    }

    @Test
    void test9() {
        Page<Author> authorsPageSort = authorRepository.findAll(PageRequest.of(1, 2, Sort.by("name")));
        System.out.println(authorsPageSort.get());
    }
}
