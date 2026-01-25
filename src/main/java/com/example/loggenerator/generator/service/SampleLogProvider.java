package com.example.loggenerator.generator.service;

import com.example.loggenerator.config.profile.LogGeneratorConfig;
import com.example.loggenerator.generator.define.LogKind;
import com.example.loggenerator.generator.define.LogSourceType;
import com.example.loggenerator.generator.define.SampleLogDefine;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class SampleLogProvider {

    private final LogGeneratorConfig config;
    private final ResourceLoader resourceLoader;

    public SampleLogProvider(LogGeneratorConfig config, ResourceLoader resourceLoader) {
        this.config = config;
        this.resourceLoader = resourceLoader;
    }

    public String getSampleLog(LogKind logKind) {
        if (config.getLogSource() == LogSourceType.IN_MEMORY) {
            return getInMemoryLog(logKind);
        } else if (config.getLogSource() == LogSourceType.LOCAL_FILE) {
            return getFileLog(logKind);
        }
        return "";
    }

    private String getInMemoryLog(LogKind logKind) {
        return switch (logKind) {
            case APPLICATION -> SampleLogDefine.APPLICATION_LOG;
            case ACCESS -> SampleLogDefine.ACCESS_LOG;
            case SYSLOG_RFC3164 -> SampleLogDefine.SYSLOG_RFC3164;
            case SYSLOG_RFC5424 -> SampleLogDefine.SYSLOG_RFC5424;
            default -> "Unknown Log Kind";
        };
    }

    private String getFileLog(LogKind logKind) {
        String filename = getFilename(logKind);
        Resource resource = resourceLoader.getResource("classpath:samples/" + filename);
        try {
            return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            // 파일이 없거나 읽을 수 없는 경우 예외 처리 또는 기본값 반환
            // 여기서는 에러 로그를 남기거나 빈 문자열을 반환하도록 처리
            return "Error reading sample file: " + filename;
        }
    }

    private String getFilename(LogKind logKind) {
        return switch (logKind) {
            case APPLICATION -> "application.log";
            case ACCESS -> "access.log";
            case SYSLOG_RFC3164 -> "SYSLOG_RFC3164.log";
            case SYSLOG_RFC5424 -> "SYSLOG_RFC5424.log";
            default -> "unknown.log";
        };
    }
}