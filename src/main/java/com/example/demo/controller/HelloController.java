package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {          //т.к. класс этот класс находится в директории главного класса, то аннотация @SpringBootApplication
    @Value("${hello.from:undefined}")
    private String from;                //подтянется автоматически и будет создан и зарегистрирован новый бин

//    public void setFrom(String from) {        //сетер не нужен, т.к. поле будет задано через Рефлекшн апи
//        this.from = from;
//    }

    @PostMapping("/hello")
    private String hello(@RequestBody Person guest) {
        return String.format("Hello from %s, name %s age %d",
                from, guest.getName(), guest.getAge());
    }
}
