package ru.yandex.qa.tech_task_8.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Managers {

    public static Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
}
