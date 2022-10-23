package ru.yandex.qa.tech_task_8.tasks;

public class SubTask extends Task {

    public SubTask(Integer id) {
        super(id);
    }

    public TaskType getTaskType() {
        return TaskType.SUB_TASK;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "id=" + id +
                '}';
    }
}
