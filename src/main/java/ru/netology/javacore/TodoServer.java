package ru.netology.javacore;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        JSONParser jParser = new JSONParser();

        try (ServerSocket serverSocket = new ServerSocket(port);
        ) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    // обработка одного подключения
                    Object obj = jParser.parse(in.readLine());
                    JSONObject jsonObject = (JSONObject) obj;
                    String task = (String) jsonObject.get("task");
                    String taskType = (String) jsonObject.get("type");
                    if (taskType.equals("ADD")) {
                        todos.addTask(task);
                        out.println(("Задача: " + task + " добавлена. Текущий список задач: " + todos.getAllTasks()));
                    }
                    if (taskType.equals("REMOVE")) {
                        todos.removeTask(task);
                        out.println(("Задача: " + task + " удалена. Текущий список задач: " + todos.getAllTasks()));
                    }
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
