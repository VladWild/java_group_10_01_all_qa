package ru.yandex.qa.tech_task;

import ru.yandex.qa.tech_task.service.PrintService;
import ru.yandex.qa.tech_task.service.print.PrintConcolServiceImpl;
import ru.yandex.qa.tech_task.service.TaskManagerService;
import ru.yandex.qa.tech_task.service.print.PrintFileServiceImpl;
import ru.yandex.qa.tech_task.task.Epic;
import ru.yandex.qa.tech_task.task.SubTask;
import ru.yandex.qa.tech_task.task.Task;
import ru.yandex.qa.tech_task.task.TaskStatus;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TaskManagerService taskManagerService = new TaskManagerService();
        PrintService printService = new PrintFileServiceImpl();

        Task task = new Task("Task 1", TaskStatus.NEW, "новыя таска");
        Task task2 = new Task("Task 2", TaskStatus.NEW, "новыя таска 2");

        taskManagerService.addTask(task);
        taskManagerService.addTask(task2);

        Epic epic = new Epic("Epic 1", TaskStatus.NEW, "новый эпик");
        Epic epic2 = new Epic("Epic 2", TaskStatus.NEW, "новый эпик 2");

        taskManagerService.addEpic(epic);
        taskManagerService.addEpic(epic2);

        SubTask subTask = new SubTask("SubTask 1", TaskStatus.IN_PROGRESS, "навая подзадача", epic.getId());
        SubTask subTask2 = new SubTask("SubTask 2", TaskStatus.IN_PROGRESS, "навая подзадача 2", epic2.getId());

        taskManagerService.addSubTask(subTask);
        taskManagerService.addSubTask(subTask2);

        //-------------------

        List<Task> tasks = taskManagerService.getTasks();
        printService.printTasks(tasks);

        List<Epic> epics = taskManagerService.getEpics();
        printService.printEpics(epics);
    }
}
