package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class HelloController {
    @Value("${hello.from:undefined}")
    private String from;

//    Пример десерриализации параметров из квери в класс
    @GetMapping("/hello")
    private String hello(@RequestParam Person guest) {
        return String.format("Hello from %s, name %s age %d",
                from, guest.getName(), guest.getAge());
    }

//    Обработка исключения
    @GetMapping("/error")
    public String error() {
        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "ResponseStatusException");
    }

//    Пример вытаскивания параметров из Квери
//    @GetMapping("/hello")
//    private String hello(@RequestParam("name") String name, @RequestParam("age") int age) {
//        return String.format("Hello from %s, name %s age %d",
//                from, name, age);
//    }

//    Пример десерреализации параметров из тела постЗапроса в объект класса
//    @PostMapping("/hello")
//    private String hello(@RequestBody Person guest) {
//        return String.format("Hello from %s, name %s age %d",
//                from, guest.getName(), guest.getAge());
//    }
}
