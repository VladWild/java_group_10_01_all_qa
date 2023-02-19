package ru.yandex.qa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.qa.model.one_to_many.Person;
import ru.yandex.qa.repository.one_to_many.PersonRepository;

import java.util.List;

@Service
public class OneToManyService {

    private final PersonRepository personRepository;

    public OneToManyService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * При этом тут получаем проблему N+1!!!!!
     */
    @Transactional
    public void printAllCars() {
        List<Person> people = personRepository.findAll();

        for (Person person : people) {
            System.out.println("У " + person + " есть машины: " + person.getCars());
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void savePerson() {
        Person person = new Person();
        person.setName("Новый человек");
        personRepository.save(person);
    }
}
