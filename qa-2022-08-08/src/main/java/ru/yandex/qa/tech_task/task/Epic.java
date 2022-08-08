package ru.yandex.qa.tech_task.task;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task{
    private List<Integer> subTaskIds = new ArrayList<>();

    public Epic(String name, TaskStatus status, String discription) {
        super(name, status, discription);
    }

    public void addTask(int subTaskId) {
        subTaskIds.add(subTaskId);
    }

    public List<Integer> getSubTaskIds() {
        return subTaskIds;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", discription='" + discription + '\'' +
                '}';
    }
}
