package com.example.loggenerator.generator.controller;

import com.example.loggenerator.config.profile.LogGeneratorConfig;
import com.example.loggenerator.generator.define.LogSourceType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/show-current-source")
    @Operation(summary = "Get Log Source", description = "Get Log Source")
    public String getLogSource() {
        return "System Log Source : " + systemConfig.getLogSource().toString();
    }

    @PostMapping("/change-source")
    @Operation(summary = "Set Log Source", description = "Set Log Source")
    public synchronized ResponseEntity<String> updateSource(@RequestParam LogSourceType newSource)
    {
        if (systemConfig.getLogSource() == newSource) {
            String message = "Log source is already set to " + newSource + ". No changes were made.";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        if (!newSource.isSupported()) {
            String errorMessage = "Unsupported log source type: " + newSource;
            logger.warn(errorMessage);
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        String before = systemConfig.getLogSource().toString();
        systemConfig.setLogSource(newSource);

        String message = "System Log Source Changed from " + before + " to " + newSource.toString();

        logger.info(message);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
