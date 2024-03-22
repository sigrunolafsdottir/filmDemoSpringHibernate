package com.example.filmdemospringhibernate.BookRESTAPI;


import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findByAuthor(String author);
    public List<Book> findByTitle(String title);

    @Query("select distinct author from Book")
    public List<String> getAllAuthors();

    @Modifying
    @Transactional
    @Query("update Book set author=:newName where author=:oldName")
    public void updateAuthorName(String oldName, String newName);

    @Modifying
    @Transactional
    @Query("update Book set author=?2 where author=?1")
    public void updateAuthorName2(@Param("oldName") String oldName, @Param("newName") String newName);

    @Query(value="select new com.example.filmdemospringhibernate.BookRESTAPI.StatUtilDTO(author, count(title))" +
            " from Book group by author")
    public List<StatUtilDTO> getAuthorStats();


}
