package com.example.loggenerator.generator.define;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "로그 소스 정의")
public enum LogSourceType {
    @Schema(description = "로컬 리소스 파일")
    LOCAL_FILE,

    @Schema(description = "데이터베이스")
    DATABASE
}
