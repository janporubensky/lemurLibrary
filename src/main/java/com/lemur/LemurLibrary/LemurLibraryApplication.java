package com.lemur.LemurLibrary;

import com.lemur.LemurLibrary.aop.Loggable;
import com.lemur.LemurLibrary.database.mongoDb.MongoRepo;
import com.lemur.LemurLibrary.database.mongoDb.dao.Books;
import com.lemur.LemurLibrary.database.mySql.MySQLRepo;
import com.lemur.LemurLibrary.database.mySql.dao.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class LemurLibraryApplication extends SpringBootServletInitializer {
	@Autowired
	private MySQLRepo repository;

	@Autowired
	private MongoRepo mongoRepo;

	public static void main(String[] args) {
		SpringApplication.run(LemurLibraryApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello() {
		return String.format("Hello");
	}
	@Loggable
	@GetMapping("/book")
	public String getABook(@RequestParam Long id){
		Book byId = repository.getById(id);
		return byId.getName();
	}

	@GetMapping("/books")
	public String getAllBooksFromMongo(){
		List<Books> books= mongoRepo.findAll();
		return books.toString();
	}
	@Loggable
	@GetMapping("/mongo/book")
	public String getBookDataByName(@RequestParam String name){
		Books byName = mongoRepo.getByName(name);
		return byName.toString();
	}
}
