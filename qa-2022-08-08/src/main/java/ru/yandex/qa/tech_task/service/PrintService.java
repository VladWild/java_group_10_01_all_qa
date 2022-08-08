package ru.yandex.qa.tech_task.service;

import ru.yandex.qa.tech_task.task.Epic;
import ru.yandex.qa.tech_task.task.Task;

import java.util.List;

public interface PrintService {

    void printTasks(List<Task> taskList);

    void printEpics(List<Epic> epics);
}
