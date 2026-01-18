package com.example.loggenerator.generator.model.config;

import com.example.loggenerator.generator.define.LogFormatDefine;
import org.productivity.java.syslog4j.SyslogConstants;

public class SyslogTaskConfig extends TaskConfig {

    private String host = "localhost";
    private int port = 5140;
    private String protocol = SyslogConstants.UDP;
    private LogFormatDefine.SyslogFormat syslogFormat;

    public SyslogTaskConfig() {
        setMessage("This is a test syslog message");
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setSyslogFormat(LogFormatDefine.SyslogFormat syslogFormat) {
        this.syslogFormat = syslogFormat;
    }

    public LogFormatDefine.SyslogFormat getSyslogFormat() {
        return syslogFormat;
    }
}
