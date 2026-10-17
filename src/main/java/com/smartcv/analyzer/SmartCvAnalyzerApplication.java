package com.smartcv.analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class SmartCvAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartCvAnalyzerApplication.class, args);
    }

    // Server start aanathum automatic-ah browser open panra logic
    @Bean
    CommandLineRunner openBrowserOnStartup() {
        return args -> {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(new URI("http://localhost:8080"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}