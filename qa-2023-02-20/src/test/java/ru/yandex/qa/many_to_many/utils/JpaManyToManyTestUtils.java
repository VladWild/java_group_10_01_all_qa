package ru.yandex.qa.many_to_many.utils;

import ru.yandex.qa.model.many_to_many.Author;

public class JpaManyToManyTestUtils {

    private JpaManyToManyTestUtils() {
    }

    public static Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return author;
    }
}
