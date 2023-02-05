package ru.yandex.qa.db.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.qa.db.model.Author;
import ru.yandex.qa.db.model.Book;
import ru.yandex.qa.db.repositories.AuthorRepository;
import ru.yandex.qa.db.repositories.BookRepository;

import java.util.List;

@Service
public class AuthorBookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorBookService(AuthorRepository authorRepository,
                             BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveAuthorWithBook(List<Author> authors, List<Book> books) {
        authorRepository.saveAll(authors);
        bookRepository.saveAll(books);
    }
}
