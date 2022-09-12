package ru.yandex.qa.techtask5.task_obj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryManagerInMemory implements HistoryManager {

    private Map<Integer, Node> nadeMap = new HashMap<>();
    private Node last;
    private Node first;

    private CustomLinkedList customLinkedList = new CustomLinkedList();

    @Override
    public void add(Task task) {

        remove(task.getId());
        linkedLast(task);
        nadeMap.put(task.getId(), last);
    }

    private void linkedLast(Task task) {
        Node newNode = new Node(task, last, null);

        //some logic
    }

    @Override
    public void removeTask(int taskId) {
        remove(taskId);
    }

    private void remove(int taskId) {
        Node node = nadeMap.get(taskId);
        if (node == null) {
            return;
        }
        //logic delete
    }

    @Override
    public List<Task> getHistory() {
        List<Task> tasks = new ArrayList<>();

        //while от first до last

        return tasks;
    }

    private class Node {
        Task task;
        Node prev;
        Node next;

        public Node(Task task, Node prev, Node next) {
            this.task = task;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "task=" + task +
                    ", prev=" + (prev != null ? prev.task : null) +
                    ", next=" + (next != null ? next.task : null) +
                    '}';
        }
    }
}
