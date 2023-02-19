package ru.yandex.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.qa.model.many_to_many.Author;
import ru.yandex.qa.model.many_to_many.BookAuthor;
import ru.yandex.qa.repository.many_to_many.AuthorRepository;
import ru.yandex.qa.repository.many_to_many.BookAuthorRepository;
import ru.yandex.qa.repository.many_to_many.BookRepository;

@Service
public class ManyToManyService {

    private final BookAuthorRepository bookAuthorRepository;
    private final OneToManyService oneToManyService;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private ManyToManyService self;

    public ManyToManyService(BookAuthorRepository bookAuthorRepository,
                             OneToManyService oneToManyService,
                             AuthorRepository authorRepository,
                             BookRepository bookRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
        this.oneToManyService = oneToManyService;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setManyToManyService(ManyToManyService self) {
        this.self = self;
    }

    /**
     * Показать RuntimeException исключение
     * if (true) {
     *    throw new RuntimeException();
     * }
     *
     * Показать Exception исключения
     * if (true) {
     *    throw new Exception();
     * }
     */
    @Transactional
    public Long saveNewAuthorAndAddToBook(String name) {
        Author author = createAuthor(name);
        Author authorSave = authorRepository.save(author);

        Long bookId = bookRepository.findIdByName("Гарри Поттер и Филасовский Камень");

        BookAuthor bookAuthor = new BookAuthor(bookId, authorSave.getId());
        BookAuthor bookAuthorSave = bookAuthorRepository.save(bookAuthor);

        return bookAuthorSave.getBookId();
    }

    /**
     * Про self-инжект сказать
     */
    public void method(String name) {

        //do something

        self.saveNewAuthorAndAddToBook(name);
    }

    @Transactional
    public void method2() {
        oneToManyService.savePerson();
        saveNewAuthorAndAddToBook("Новый автор");
    }

    private static Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return author;
    }
}
