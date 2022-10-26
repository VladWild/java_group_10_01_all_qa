package ru.yandex.qa.tech_task_8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.yandex.qa.tech_task_8.http.KVTaskClient;
import ru.yandex.qa.tech_task_8.manager.impl.FileBackedTaskManager;
import ru.yandex.qa.tech_task_8.tasks.Task;

import java.io.File;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        /*FileBackedTaskManager fileBackedTaskManager =
                new FileBackedTaskManager(new File("qa-2022-10-24/src/main/resources/tasks.csv"));
        fileBackedTaskManager.addNewTask(new Task(1));*/

        KVTaskClient kvTaskClient = new KVTaskClient();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        String str = gson.toJson(Collections.singletonList(new Task(2)));

        kvTaskClient.save("tasks", str);

        System.out.println(kvTaskClient);
    }
}
