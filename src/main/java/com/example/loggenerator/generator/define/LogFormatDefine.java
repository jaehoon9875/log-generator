package com.example.loggenerator.generator.define;

/**
 * 생성할 로그의 포맷 종류를 정의하는 클래스입니다.
 * enum을 사용하여 로그 포맷을 관리합니다.
 */
public class LogFormatDefine {

    public enum LogFormat {
        JSON,       // JSON 형식
        KEY_VALUE,  // Key-Value 형식 (예: logfmt)
        CSV,        // Comma-Separated Values 형식
        XML,        // XML 형식
        PLAIN_TEXT  // 일반 텍스트 형식
    }

    public enum SyslogFormat {
        RFC_3164,   // RFC 3164 형식
        RFC_5424   // RFC 5424 형식
    }
}
