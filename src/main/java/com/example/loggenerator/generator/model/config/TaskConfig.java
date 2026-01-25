package com.example.loggenerator.generator.model.config;

public abstract class TaskConfig {

    protected int eps = 1; // Events Per Second
    protected String message = "this is test message";
    protected int count = 100; // total number of logs to generate

    public int getEps() {
        return eps;
    }

    public void setEps(int eps) {
        this.eps = eps;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
