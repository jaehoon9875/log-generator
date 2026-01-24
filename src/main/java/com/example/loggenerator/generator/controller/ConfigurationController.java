package com.example.loggenerator.generator.controller;

import com.example.loggenerator.config.profile.LogGeneratorConfig;
import com.example.loggenerator.generator.define.LogSourceType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
@Tag(name = "Configuration Controller", description = "Config Controller for generating logs")
public class ConfigurationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final LogGeneratorConfig systemConfig;

    public ConfigurationController(LogGeneratorConfig systemConfig) {
        this.systemConfig = systemConfig;
    }

    @GetMapping("/source")
    @Operation(summary = "Get Log Source", description = "Get Log Source")
    public LogSourceType getLogSource() {
        return systemConfig.getLogSource();
    }

    @PostMapping("/source")
    @Operation(summary = "Set Log Source", description = "Set Log Source")
    public String updateSource(@RequestParam LogSourceType newSource)
    {
        String before = systemConfig.getLogSource().toString();
        systemConfig.setLogSource(newSource);
        return "System Log Source Changed from" + before + " to " + newSource.toString();
    }

}
