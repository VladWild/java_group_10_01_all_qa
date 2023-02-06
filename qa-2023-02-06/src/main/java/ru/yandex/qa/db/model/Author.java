package ru.yandex.qa.db.model;

import jakarta.persistence.*;
import ru.yandex.qa.db.model.base.BaseModel;

@Entity
@Table(name = "authors")
public class Author extends BaseModel<Long> {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
