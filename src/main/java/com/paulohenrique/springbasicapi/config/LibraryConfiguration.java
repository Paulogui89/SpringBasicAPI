package com.paulohenrique.springbasicapi.config;

import com.paulohenrique.springbasicapi.model.Library;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDate;


@Configuration
@Slf4j
public class LibraryConfiguration {

    @Bean
    public Library library(){
        Library lb = new Library("Java for dumbies", "me", LocalDate.now());
        Library lb2 = new Library("Java for dumbies 2", "me", LocalDate.now());
        Library lb3 = new Library("Java for dumbies 3", "me", LocalDate.now());
        Library lb4 = new Library("Java for dumbies 4", "me", LocalDate.now());
        log.info(lb.listToString());
        return lb;
    }
}
