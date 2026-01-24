package com.example.loggenerator.generator.define;

public class SampleLogDefine {
    // Application Log
    public static final String APPLICATION_LOG = "2024-05-27 10:00:00.000 INFO [main] com.example.loggenerator.LogGeneratorApplication - Application started successfully.";

    // Access Log (Common Log Format)
    public static final String ACCESS_LOG = "127.0.0.1 - - [27/May/2024:10:00:00 +0900] \"GET /index.html HTTP/1.1\" 200 1500";

    // Syslog (RFC 3164)
    public static final String SYSLOG_RFC3164 = "<34>May 27 10:00:00 mymachine sudo: pam_unix(sudo:session): session opened for user root by (uid=0)";

    // Syslog (RFC 5424)
    public static final String SYSLOG_RFC5424 = "<34>1 2024-05-27T10:00:00.000Z mymachine sudo - - - pam_unix(sudo:session): session opened for user root by (uid=0)";
}
