package com.lemur.LemurLibrary.database.mongoDb;

import com.lemur.LemurLibrary.database.mongoDb.dao.Books;
import com.lemur.LemurLibrary.database.mySql.dao.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoRepo extends MongoRepository<Books, String> {
    Books getByName(String name);
    List<Books> findAll();
}
