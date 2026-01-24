package com.example.loggenerator.generator.define;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "로그 소스 정의")
public enum LogSourceType {
    @Schema(description = "로컬 리소스 파일")
    LOCAL_FILE(true),

    @Schema(description = "데이터베이스")
    DATABASE(false),

    @Schema(description = "인메모리")
    IN_MEMORY(true);

    private final boolean supported;

    LogSourceType(boolean supported) {
        this.supported = supported;
    }

    public boolean isSupported() {
        return supported;
    }
}
