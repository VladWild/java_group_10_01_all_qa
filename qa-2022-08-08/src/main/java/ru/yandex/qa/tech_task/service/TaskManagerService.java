package ru.yandex.qa.tech_task.service;

import ru.yandex.qa.tech_task.task.Epic;
import ru.yandex.qa.tech_task.task.SubTask;
import ru.yandex.qa.tech_task.task.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagerService {
    private Map<Integer, Task> tasks = new HashMap<>();
    private Map<Integer, SubTask> subTasks = new HashMap<>();
    private Map<Integer, Epic> epics = new HashMap<>();

    private int generator = 0;

    public void addTask(Task task) {
        int taskId = ++generator;
        task.setId(taskId);
        tasks.put(taskId, task);
    }

    public void addEpic(Epic epic) {
        epic.setId(++generator);
        epics.put(epic.getId(), epic);
    }

    public void addSubTask(SubTask subTask) {
        int epicId = subTask.getEpicId();
        Epic epic = epics.get(epicId);
        if (epic == null) {
            return;
        }
        //сохраняем подзадачу
        int subTaskId = ++generator;
        subTask.setId(subTaskId);
        subTasks.put(subTaskId, subTask);
        //добавить эпик в подзадачу
        epic.addTask(subTaskId);
        updateEpicStatic(epic);
    }

    public List<Task> getTasks() {
        Collection<Task> values = tasks.values();
        return new ArrayList<>(values);
    }

    public List<Epic> getEpics() {
        Collection<Epic> values = epics.values();
        return new ArrayList<>(values);
    }


    private void updateEpicStatic(Epic epic) {
        //логика опредения статуса эпика
    }
}
