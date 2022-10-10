package ru.yandex.qa.tech_task_7.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.qa.tech_task_7.tasks.Task;

import java.util.List;

public abstract class TaskManagerTest<T extends TaskManager> {

    protected T taskManager;

    protected void initTask() {
        taskManager.addNewTask(new Task(1));
        taskManager.addNewTask(new Task(2));
    }

    @Test
    @DisplayName("Проверка получения тасок")
    void getTasksTest() {
        taskManager.addNewTask(new Task(3));
        List<Task> tasks = taskManager.getTasks();

        Assertions.assertAll(
                () -> Assertions.assertEquals(3, tasks.size()),
                () -> Assertions.assertTrue(tasks.contains(new Task(1))),
                () -> Assertions.assertTrue(tasks.contains(new Task(2))),
                () -> Assertions.assertTrue(tasks.contains(new Task(3))),
                () -> Assertions.assertFalse(tasks.contains(new Task(4)))
        );
    }
}
