package ru.yandex.qa.tech_task_8.manager.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.yandex.qa.tech_task_8.http.KVTaskClient;
import ru.yandex.qa.tech_task_8.tasks.Task;

import java.util.Collections;

public class HttpTaskManager extends FileBackedTaskManager {

    //Gson gson = gsonBuilder.create();

    KVTaskClient kvTaskClient = new KVTaskClient();

    public HttpTaskManager() {
        super(null);
    }

    @Override
    protected void save() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String str = gson.toJson(Collections.singletonList(new Task(2)));

        kvTaskClient.save("tasks", str);

        //epics
        //subtask
        //history
    }
}
