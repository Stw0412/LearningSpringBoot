package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Team Sutthiwat silaket") String name) {
        return String.format("Hello %s", name);
    }

    @PostMapping("/hello")
    public HelloResponse hello(@RequestBody HelloName request) {
        String name = request.getName();
        return new HelloResponse("Hello, " + name);
    }
}

