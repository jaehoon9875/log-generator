package com.example.loggenerator.generator.controller;

import com.example.loggenerator.generator.model.task.LogTask;
import com.example.loggenerator.generator.model.config.SyslogTaskConfig;
import com.example.loggenerator.generator.service.SyslogGenerator;
import com.example.loggenerator.generator.service.TaskRegistry;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/syslog")
@Tag(name = "Syslog Generator", description = "Generate Syslog messages")
public class SyslogGenerateController {

    // test
    private final TaskRegistry taskRegistry;

    public SyslogGenerateController(TaskRegistry taskRegistry) {
        this.taskRegistry = taskRegistry;
    }

    @PostMapping("/generate")
    public String generateSyslog(@RequestBody SyslogTaskConfig config) {
        LogTask task = new SyslogGenerator(config);
        taskRegistry.registerAndStart(task);
        return task.getTaskId();
    }

    @PostMapping("/{taskId}/stop")
    public void stopSyslog(@PathVariable String taskId) {
        taskRegistry.stop(taskId);
    }

    @GetMapping("/{taskId}")
    public String getTaskState(@PathVariable String taskId) {
        LogTask task = taskRegistry.getTask(taskId);
        if (task != null) {
            return task.getState().toString();
        }
        return "Task not found";
    }

    @GetMapping("/tasks")
    public Map<String, String> getAllTasks() {
        return taskRegistry.getAllTasks().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getState().toString()));
    }
}
