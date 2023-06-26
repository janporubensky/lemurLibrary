package com.lemur.LemurLibrary.database.mySql.dao;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Age", nullable = false)
    private int age;
}
