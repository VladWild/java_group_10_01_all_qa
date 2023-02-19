package ru.yandex.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.qa.model.many_to_many.Author;
import ru.yandex.qa.model.many_to_many.Book;
import ru.yandex.qa.repository.many_to_many.AuthorRepository;
import ru.yandex.qa.repository.many_to_many.BookRepository;

@Service
public class ManyToManyService {

    private final OneToManyService oneToManyService;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private ManyToManyService self;

    public ManyToManyService(OneToManyService oneToManyService,
                             AuthorRepository authorRepository,
                             BookRepository bookRepository) {
        this.oneToManyService = oneToManyService;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setManyToManyService(ManyToManyService self) {
        this.self = self;
    }

    /**
     * Показать Exception исключения
     * if (true) {
     *    throw new Exception();
     * }
     */
    @Transactional
    public void saveNewAuthorAndAddToBook(String name) {
        Author author = createAuthor(name);
        Author authorSave = authorRepository.save(author);

        Book book = bookRepository.findByIdEntityGraph(100000L);
        book.getAuthors().add(authorSave);

        Book bookSave = bookRepository.save(book);
        System.out.println(bookSave);
    }

    /**
     * Про self-инжект сказать
     */
    public void method(String name) {
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
