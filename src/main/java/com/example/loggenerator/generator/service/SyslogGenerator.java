package com.example.loggenerator.generator.service;

import com.example.loggenerator.generator.define.TaskState;
import com.example.loggenerator.generator.model.config.SyslogTaskConfig;
import com.example.loggenerator.generator.model.task.LogTask;
import com.example.loggenerator.generator.util.IdGenerator;
import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.SyslogIF;

public class SyslogGenerator implements LogTask {

    private final String taskId;
    private final SyslogTaskConfig config;
    private volatile TaskState state;
    private final SyslogIF syslog;

    public SyslogGenerator(SyslogTaskConfig config) {
        this.taskId = IdGenerator.getUuid();
        this.config = config;
        this.state = TaskState.STOPPED;
        this.syslog = Syslog.getInstance(config.getProtocol());
        this.syslog.getConfig().setHost(config.getHost());
        this.syslog.getConfig().setPort(config.getPort());
    }

    @Override
    public void run() {
        state = TaskState.RUNNING;
        long delay = 1000 / config.getEps();
        int count = config.getCount();

        try {
            for (int i = 0; i < count && state == TaskState.RUNNING; i++) {
                syslog.info(config.getMessage());
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            state = TaskState.STOPPED;
            syslog.shutdown();
        }
    }

    @Override
    public void stop() {
        this.state = TaskState.STOPPED;
    }

    @Override
    public TaskState getState() {
        return state;
    }

    @Override
    public String getTaskId() {
        return taskId;
    }
}
