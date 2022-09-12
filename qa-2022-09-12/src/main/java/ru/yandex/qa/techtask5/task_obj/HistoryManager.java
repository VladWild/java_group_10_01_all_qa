package ru.yandex.qa.techtask5.task_obj;

import java.util.List;

public interface HistoryManager {

    void add(Task task);

    void removeTask(int taskId);

    List<Task> getHistory();
}
