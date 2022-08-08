package ru.yandex.qa.tech_task.service.print;

import ru.yandex.qa.tech_task.service.PrintService;
import ru.yandex.qa.tech_task.task.Epic;
import ru.yandex.qa.tech_task.task.Task;

import java.util.List;

public class PrintConcolServiceImpl implements PrintService {

    public void printTasks(List<Task> taskList) {
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    public void printEpics(List<Epic> epics) {
        for (Epic epic : epics) {
            System.out.println("У эпика " + epic + " есть подзадачи " + epic.getSubTaskIds());
        }
    }
}
