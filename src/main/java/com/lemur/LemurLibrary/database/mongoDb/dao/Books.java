package com.lemur.LemurLibrary.database.mongoDb.dao;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("books")
public class Books {
    @Id
    public String id;

    public String name;

    public String author;

    public String author_age;
}
