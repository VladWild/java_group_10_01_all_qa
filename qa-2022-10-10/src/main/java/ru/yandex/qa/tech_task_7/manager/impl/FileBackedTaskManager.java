package ru.yandex.qa.tech_task_7.manager.impl;

import ru.yandex.qa.tech_task_7.tasks.Epic;
import ru.yandex.qa.tech_task_7.tasks.SubTask;
import ru.yandex.qa.tech_task_7.tasks.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class FileBackedTaskManager extends InMemoryTaskManager {
    private final File file;

    public FileBackedTaskManager(File file) {
        this.file = file;
    }

    @Override
    public int addNewTask(Task task) {
        int i = super.addNewTask(task);
        save();
        return i;
    }

    private void save() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            bufferedWriter.write("id,type");
            bufferedWriter.newLine();

            Collection<Task> values = tasks.values();
            for (Task value : values) {
                bufferedWriter.write(value.getId() + "," + value.getTaskType());
                bufferedWriter.newLine();
            }

            Collection<Epic> valuesE = epics.values();
            for (Epic value : valuesE) {
                bufferedWriter.write(value.getId() + "," + value.getTaskType());
                bufferedWriter.newLine();
            }

            Collection<SubTask> valuesS = subTasks.values();
            for (SubTask value : valuesS) {
                bufferedWriter.write(value.getId() + "," + value.getTaskType());
                bufferedWriter.newLine();
            }

            bufferedWriter.newLine();

            //history

        } catch (IOException e) {
            System.out.println(e);
            //throw new RuntimeException(e);
        }
    }
}
