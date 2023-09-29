package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
Через аннотацию @ConfigurationProperties задается свойство hello. в Файле application.properties через это свойство и точку
идет обращение к переменной from и ей присваивается значение. Для работы Спринга необходимо, чтобы у него был доступ к переменной
через сетер.
 */
@ConfigurationProperties("hello")
@RestController
public class HelloController {          //т.к. класс этот класс находится в директории главного класса, то аннотация @SpringBootApplication
    private String from;                //подтянется автоматически и будет создан и зарегистрирован новый бин

    public void setFrom(String from) {
        this.from = from;
    }

    @GetMapping("/")
    private String hello() {
        return String.format("Hello from %s", from);
    }
}
