package com.example.loggenerator.generator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/syslog")
@Tag(name = "Syslog Generator", description = "Generate Syslog messages")
public class SyslogGenerateController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // syslog4j를 이용해서 syslog 메시지를 생성한다.

    @PostMapping("/generate")
    public String generateSyslog() {
        logger.info("Syslog message generated");
        return "Syslog message generated";
    }
}
