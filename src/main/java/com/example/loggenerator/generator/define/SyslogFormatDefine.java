package com.example.loggenerator.generator.define;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Syslog 포맷")
public enum SyslogFormatDefine {
    @Schema(description = "RFC 3164 형식")
    RFC_3164,
    @Schema(description = "RFC 5424 형식")
    RFC_5424
}
