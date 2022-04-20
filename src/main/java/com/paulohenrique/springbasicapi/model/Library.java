package com.paulohenrique.springbasicapi.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Library {

    public static List<Library> list = new ArrayList<>();

    private long id;

    private String bookName = "";

    private String authorName = "";

    @DateTimeFormat(pattern = "yyyy/mm/dd")private LocalDate publishedDate = LocalDate.of(1900, 1, 1);

    public Library(String bookName, String authorName, LocalDate publishedDate) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishedDate = publishedDate;
        listMaintance(this);
    }

    public Library() {
        listMaintance(this);
    }

    private void listMaintance(Library library){
        if(!list.isEmpty()){
            library.id = list.get(list.size()-1).id + 1;
        }else {
            library.id = 1;
        }
        list.add(library);
    }

    public String listToString(){
        if(!list.isEmpty()){
            String result = "";
            for (Library lib: list){
                result = result.concat(String.valueOf(lib.id)).concat(" - ")
                        .concat(bookName).concat(" - ")
                        .concat(authorName).concat(" - ")
                        .concat(publishedDate.toString()).concat(" | ");
            }
            return result;
        }else {
            return "";
        }
    }
}


