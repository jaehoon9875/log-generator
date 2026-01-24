package com.example.loggenerator.config.profile;

import com.example.loggenerator.generator.define.LogSourceType;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.loggenerator.generator")
public class LogGeneratorConfig {
    // default local file
    private LogSourceType logSource = LogSourceType.LOCAL_FILE;

    public void setLogSource(LogSourceType logSource) {
        this.logSource = logSource;
    }

    public LogSourceType getLogSource() {
        return logSource;
    }
}
