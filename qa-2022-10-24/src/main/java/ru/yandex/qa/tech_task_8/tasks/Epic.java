package ru.yandex.qa.tech_task_8.tasks;

public class Epic extends Task {

    public Epic(Integer id) {
        super(id);
    }

    public TaskType getTaskType() {
        return TaskType.EPIC;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                '}';
    }
}
