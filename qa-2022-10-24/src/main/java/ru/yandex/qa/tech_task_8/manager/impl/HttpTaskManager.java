package ru.yandex.qa.tech_task_8.manager.impl;

import com.google.gson.Gson;
import ru.yandex.qa.tech_task_8.http.KVTaskClient;
import ru.yandex.qa.tech_task_8.manager.Managers;
import ru.yandex.qa.tech_task_8.tasks.Task;

import java.io.File;
import java.util.Collections;

public class HttpTaskManager extends FileBackedTaskManager {

    KVTaskClient kvTaskClient = new KVTaskClient();
    Gson gson = Managers.getGson();

    public HttpTaskManager() {
        super(null);
    }

    public void load() {

    }

    @Override
    protected void save() {
        String jsonStr = gson.toJson(Collections.singletonList(new Task(1)));
        kvTaskClient.save("tasks", jsonStr);

        //epics
        //subtask

        //history
    }
}
