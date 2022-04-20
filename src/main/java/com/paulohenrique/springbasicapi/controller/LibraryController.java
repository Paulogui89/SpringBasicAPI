package com.paulohenrique.springbasicapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @GetMapping("/hello")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello %s! Let's Start!", name);
    }

}
