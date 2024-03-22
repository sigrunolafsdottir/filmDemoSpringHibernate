package com.example.filmdemospringhibernate;

import com.example.filmdemospringhibernate.BookRESTAPI.Book;
import com.example.filmdemospringhibernate.BookRESTAPI.BookRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FilmDemoSpringHibernateApplication {


    public static void main(String[] args) {
        SpringApplication.run(FilmDemoSpringHibernateApplication.class, args);
    }


/*
    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            // save a few books
            repository.save(new Book("Pippi", "Astrid Lindgren"));
            repository.save(new Book("Emil", "Astrid Lindgren"));
            repository.save(new Book("Karlsson", "Astrid Lindgren"));
            repository.save(new Book("Pale King", "David Foster Wallace"));
            repository.save(new Book("Idioten", "Dostoyevsky"));

        };
    }

*/
}
