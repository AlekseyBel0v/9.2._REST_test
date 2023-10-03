package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/error")
public class BrokenController {

    @GetMapping("/{id}")
    public Person getPersonByID(@PathVariable("id") long id) {
        try {
            throw new IllegalArgumentException("Пользователь с id %d не был найден");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(e.getMessage(), id), e);
        }
    }
}