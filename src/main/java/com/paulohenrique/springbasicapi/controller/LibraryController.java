package com.paulohenrique.springbasicapi.controller;

import com.paulohenrique.springbasicapi.model.Library;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {

    @GetMapping("/hello")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello %s! Let's Start!", name);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Library>> returnList(){
        return ResponseEntity.ok(Library.list);
    }

}
