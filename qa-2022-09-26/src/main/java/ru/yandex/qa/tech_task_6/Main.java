package ru.yandex.qa.tech_task_6;

import ru.yandex.qa.tech_task_6.manager.impl.FileBackedTaskManager;
import ru.yandex.qa.tech_task_6.tasks.Task;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        FileBackedTaskManager fileBackedTaskManager =
                new FileBackedTaskManager(new File("qa-2022-09-26/src/main/resources/tasks.csv"));
        fileBackedTaskManager.addNewTask(new Task(1));
    }
}
