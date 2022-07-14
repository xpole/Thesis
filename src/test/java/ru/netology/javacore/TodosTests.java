package ru.netology.javacore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTests {

    // ваши тесты для класса Todos
    @Test
    public void addTaskTest() {
        Todos taskList = new Todos();
        taskList.addTask("Акробатика");
        assertEquals(taskList.getAllTasks(), "Акробатика");
    }
    @Test
    public void removeTaskTest() {
        Todos taskList = new Todos();
        taskList.addTask("Акробатика");
        taskList.addTask("Пробежка");
        taskList.removeTask("Пробежка");
        assertEquals(taskList.getAllTasks(), "Акробатика");
    }
    @Test
    public void getAllTasksTest() {
        Todos taskList = new Todos();
        taskList.addTask("Учёба");
        taskList.addTask("Пробежка");
        taskList.addTask("Акробатика");
        assertEquals(taskList.getAllTasks(), "Акробатика Пробежка Учёба");
    }
}
