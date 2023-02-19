package ru.yandex.qa.model.one_to_many;

import ru.yandex.qa.model.BaseModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
@NamedEntityGraph(name = "Person.cars", attributeNodes = @NamedAttributeNode("cars"))
public class Person extends BaseModel<Long> {

    private String name;
    private Set<Car> cars = new HashSet<>();

    @Id
    @Override
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "person")
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
