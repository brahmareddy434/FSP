package com.example.spring_k8s_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        log.info("Hello API request received...");
        return "Hello from Spring Boot kubaernates Demo";
    }

}
