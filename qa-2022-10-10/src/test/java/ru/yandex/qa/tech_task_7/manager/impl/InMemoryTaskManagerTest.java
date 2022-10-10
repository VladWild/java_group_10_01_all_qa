package ru.yandex.qa.tech_task_7.manager.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.qa.tech_task_7.manager.TaskManagerTest;
import ru.yandex.qa.tech_task_7.tasks.Task;

import java.util.List;

@DisplayName("Проверка сервиса InMemoryTaskManagerTest")
class InMemoryTaskManagerTest extends TaskManagerTest<InMemoryTaskManager> {

    @BeforeEach
    void setUp() {
        taskManager = new InMemoryTaskManager();
        initTask(); //общие данные
    }

    @Test
    void test() {
        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
        //do something
    }
}