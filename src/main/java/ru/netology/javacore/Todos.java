package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
     List<String> taskList = new ArrayList<>();

    public void addTask(String task) {
        taskList.add(task);
    }

    public void removeTask(String task) {
        taskList.removeAll(Collections.singleton(task));
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        return taskList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(" "));
    }

}
