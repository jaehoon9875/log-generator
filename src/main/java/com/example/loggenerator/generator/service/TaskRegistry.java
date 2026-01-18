package com.example.loggenerator.generator.service;

import com.example.loggenerator.generator.model.task.LogTask;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TaskRegistry {

    private final Map<String, LogTask> tasks = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void registerAndStart(LogTask task) {
        tasks.put(task.getTaskId(), task);
        executorService.submit(task);
    }

    public void stop(String taskId) {
        LogTask task = tasks.get(taskId);
        if (task != null) {
            task.stop();
        }
    }

    public LogTask getTask(String taskId) {
        return tasks.get(taskId);
    }

    public Map<String, LogTask> getAllTasks() {
        return tasks;
    }
}
