package ru.yandex.qa.tech_task_7.manager.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.qa.tech_task_7.manager.TaskManagerTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileBackedTaskManagerTest extends TaskManagerTest<FileBackedTaskManager> {

    private File file;

    @BeforeEach
    void setUp() {
        file = new File("qa-2022-10-10/src/main/resources/tasks.csv");
        taskManager = new FileBackedTaskManager(file);
        initTask(); //общие данные
    }

    @AfterEach
    void cleanUp() {
        file.delete();
    }

    @Test
    void loadFromFileTest() {

    }
}