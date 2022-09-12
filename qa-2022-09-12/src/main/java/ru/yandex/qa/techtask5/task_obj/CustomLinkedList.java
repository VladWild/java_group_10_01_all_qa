package ru.yandex.qa.techtask5.task_obj;

import java.util.HashMap;
import java.util.Map;

public class CustomLinkedList {

    private Map<Integer, Node> nadeMap = new HashMap<>();
    private Node last;
    private Node first;

    public void add(Task task) {

    }

    public void remove(int taskId) {

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
