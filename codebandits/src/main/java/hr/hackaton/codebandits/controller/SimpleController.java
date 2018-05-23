package hr.hackaton.codebandits.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage() {
       return "OK";
    }

    @GetMapping("/status")
    public Map<String, Object> status() {
        return Collections.singletonMap("status", "OK");
    }
}
