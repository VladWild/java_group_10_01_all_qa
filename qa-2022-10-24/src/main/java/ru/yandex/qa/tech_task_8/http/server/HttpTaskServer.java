package ru.yandex.qa.tech_task_8.http.server;

import ru.yandex.qa.tech_task_8.manager.TaskManager;
import ru.yandex.qa.tech_task_8.manager.impl.HttpTaskManager;

public class HttpTaskServer {
    TaskManager taskManager = new HttpTaskManager();

    public HttpTaskServer() {
        //HttpServer
        //8080
    }

    public static void main(String[] args) {

    }
}
