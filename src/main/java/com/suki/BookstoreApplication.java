package com.suki;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.suki.model.Book;
import com.suki.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(BookRepository repository){
		return (args) -> {
			repository.save(new Book(1, "Harry Potter and Stuff", "J.K.Rowling", 2017, "12345", 20));
			repository.save(new Book(2, "Harry Potter and Things", "J.K.Rowling", 2015, "67891", 20));
		};
	}
}
