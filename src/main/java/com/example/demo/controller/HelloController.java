package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Value("${hello.from:undefined}")
    private String from;

    @GetMapping("/hello")
    private String hello(@RequestParam Person guest) {
        return String.format("Hello from %s, name %s age %d",
                from, guest.getName(), guest.getAge());
    }

//    Пример десерреализации параметров из тела постЗапроса в объект класса
//    @PostMapping("/hello")
//    private String hello(@RequestBody Person guest) {
//        return String.format("Hello from %s, name %s age %d",
//                from, guest.getName(), guest.getAge());
//    }
}
