package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {          //т.к. класс этот класс находится в директории главного класса, то аннотация @SpringBootApplication
    @Value("${hello.from:undefined}")
    private String from;                //подтянется автоматически и будет создан и зарегистрирован новый бин

//    public void setFrom(String from) {        //сетер не нужен, т.к. поле будет задано через Рефлекшн апи
//        this.from = from;
//    }

    @GetMapping("/")
    private String hello() {
        return String.format("Hello from %s", from);
    }
}
