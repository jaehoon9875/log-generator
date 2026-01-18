package com.example.loggenerator.generator.model.task;

import com.example.loggenerator.generator.define.TaskState;

public interface LogTask extends Runnable {

    void stop();

    TaskState getState();

    String getTaskId();
}
