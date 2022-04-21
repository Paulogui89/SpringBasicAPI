package com.paulohenrique.springbasicapi.controller;

import com.paulohenrique.springbasicapi.model.Library;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/library")
    public ResponseEntity<Library> create(@RequestBody Library lib){
        return ResponseEntity.ok(lib);
    }

    @GetMapping("/library/{id}")
    public ResponseEntity<Library> read(@PathVariable long id) throws Exception {
        Library lib = Library.list.stream().filter(l -> l.getId() == id)
                .findFirst().orElseThrow(() ->new Exception("invalid id: " + id));

        return ResponseEntity.ok(lib);
    }

    @PutMapping("/library/{id}")
    public ResponseEntity<Library> update(@RequestBody Library lib, @PathVariable long id) throws Exception {
        Library.list.remove(Library.list.size()-1);
        Library updateLib = Library.list.stream().filter(l -> l.getId() == id)
                .findFirst().orElseThrow(() ->new Exception("invalid id: " + id));
        updateLib.setAuthorName(lib.getAuthorName());
        updateLib.setBookName(lib.getBookName());
        updateLib.setPublishedDate(lib.getPublishedDate());

        return ResponseEntity.ok(updateLib);
    }

    @DeleteMapping("/library/{id}")
    public ResponseEntity<Library> delete(@PathVariable long id) throws Exception {
        Library lib = Library.list.stream().filter(l -> l.getId() == id)
                .findFirst().orElseThrow(() ->new Exception("invalid id: " + id));

        Library.list.remove(lib);

        return ResponseEntity.ok(lib);
    }

}
