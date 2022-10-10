package ru.yandex.qa.tech_task_7.tasks;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                '}';
    }
}
