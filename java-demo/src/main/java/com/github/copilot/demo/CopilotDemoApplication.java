package com.github.copilot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class for GitHub Copilot Demo
 * 
 * Copilot Usage Example:
 * - Type: "// Spring Boot main application" and let Copilot generate the @SpringBootApplication annotation
 * - Type: "public static void main" and Copilot will suggest the full main method
 */
@SpringBootApplication
public class CopilotDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CopilotDemoApplication.class, args);
    }
}
