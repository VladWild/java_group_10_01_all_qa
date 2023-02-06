package ru.yandex.qa.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@IdClass(BookAuthor.class)
@Table(name = "book_author")
public class BookAuthor implements Serializable {

    public BookAuthor() {
    }

    public BookAuthor(Long bookId, Long authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    private Long bookId;
    private Long authorId;

    @Id
    @Column(name = "book_id")
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Id
    @Column(name = "author_id")
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
