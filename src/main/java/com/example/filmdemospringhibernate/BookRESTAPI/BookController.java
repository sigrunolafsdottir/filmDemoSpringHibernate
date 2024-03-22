package com.example.filmdemospringhibernate.BookRESTAPI;


import com.example.filmdemospringhibernate.FilmDemoSpringHibernateApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository repo;
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    BookController(BookRepository repo){
        this.repo = repo;
    }

    @RequestMapping("books")
    public List<Book> getAllBooks(){

        log.info("All books returned");
      //  log.error("All books returned in ERROR mess");
      //  log.warn("All books returned in WARNING mess");
      //  log.debug("All books returned in DEBUG mess");
        return repo.findAll();
    }

    @RequestMapping("books/{id}")
    public Book findById(@PathVariable long id){
        log.info("Book found with id "+id);
        return repo.findById(id).get();
    }

    @RequestMapping("books/{author}/author")
    public List<Book> findByAuthor(@PathVariable String author){
        return repo.findByAuthor(author);
    }

    @RequestMapping("books/{id}/delete")
    public List<Book> deleteById(@PathVariable long id){
        repo.deleteById(id);
        log.info("Book deleted with id "+id);
        return repo.findAll();
    }

    @PostMapping("books/add")
    public List<Book> addBooks(@RequestBody Book b){
        repo.save(b);
        return repo.findAll();
    }

    @RequestMapping("books/getAuthors")
    public List<String> getAuthors(){
        return repo.getAllAuthors();
    }

    @RequestMapping("books/updateName1")
    public void updateName1(){
         repo.updateAuthorName("Dosty", "D");
    }

    @RequestMapping("books/updateName2")
    public void updateName2(){
        repo.updateAuthorName2("D", "Dosty");
    }

    @RequestMapping("books/getStats")
    public List<StatUtilDTO> getStats(){
        return repo.getAuthorStats();
    }

}
