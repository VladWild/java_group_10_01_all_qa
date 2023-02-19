package ru.yandex.qa;

import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.qa.config.DbConfig;
import ru.yandex.qa.service.ManyToManyService;
import ru.yandex.qa.service.OneToManyService;

@AutoConfigureDataJpa
@SpringBootTest(classes = {DbConfig.class, OneToManyService.class, ManyToManyService.class},
        properties = {
                "spring.jpa.properties.hibernate.format_sql=true",
                "spring.jpa.show-sql=true",
                "spring.main.allow-circular-references=true"
        })
public abstract class JpaTest {
}
