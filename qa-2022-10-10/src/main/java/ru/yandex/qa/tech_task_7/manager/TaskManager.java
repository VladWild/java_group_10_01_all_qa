package ru.yandex.qa.tech_task_7.manager;

import ru.yandex.qa.tech_task_7.tasks.Task;

import java.util.List;

public interface TaskManager {

    int addNewTask(Task task);

    List<Task> getTasks();
}
