package ru.yandex.qa.db.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import ru.yandex.qa.db.model.base.BaseModel;

@Entity
@Table(name = "pages")
public class Page extends BaseModel<String> {

    private String text;

    private Book book;

    @Id
    @Override
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Page{" +
                "text='" + text + '\'' +
                ", book=" + book +
                '}';
    }
}
