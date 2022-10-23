package ru.yandex.qa.tech_task_8;

import com.google.gson.Gson;
import ru.yandex.qa.tech_task_8.http.KVTaskClient;
import ru.yandex.qa.tech_task_8.manager.Managers;
import ru.yandex.qa.tech_task_8.tasks.Task;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        KVTaskClient kvTaskClient = new KVTaskClient();
        Gson gson = Managers.getGson();

        String jsonStr = gson.toJson(Collections.singletonList(new Task(1)));
        kvTaskClient.save("tasks", jsonStr);
    }
}
