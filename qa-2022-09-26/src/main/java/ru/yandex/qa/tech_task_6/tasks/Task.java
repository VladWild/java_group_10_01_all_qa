package ru.yandex.qa.tech_task_6.tasks;

public class Task {
    protected final Integer id;

    public Task(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public TaskType getTaskType() {
        return TaskType.TASK;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                '}';
    }
}
