package com.lemur.LemurLibrary.database.mySql;

import com.lemur.LemurLibrary.database.mySql.dao.Author;
import com.lemur.LemurLibrary.database.mySql.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MySQLRepo extends JpaRepository<Book, Long> {
   // List<Book> getAllBooks();

    Book findABookByName(String name);

    Book getById(Long id);
}
